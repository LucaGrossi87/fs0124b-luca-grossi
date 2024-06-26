package it.epicode.valhallagaming.controller;

import it.epicode.valhallagaming.dto.bookingDTO.BookingCreateRequest;
import it.epicode.valhallagaming.dto.bookingDTO.BookingDeleteResponse;
import it.epicode.valhallagaming.dto.bookingDTO.BookingEditRequest;
import it.epicode.valhallagaming.dto.bookingDTO.BookingResponse;
import it.epicode.valhallagaming.entity.Admin;
import it.epicode.valhallagaming.entity.Booking;
import it.epicode.valhallagaming.entity.Station;
import it.epicode.valhallagaming.entity.User;
import it.epicode.valhallagaming.service.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StationService stationService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        return booking.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public BookingResponse createBooking(@RequestBody BookingCreateRequest bookingCreateRequest) {
        Booking booking = convertToEntity(bookingCreateRequest);
        Booking savedBooking = bookingService.save(booking);
        return convertToDTO(savedBooking);
    }

    @PutMapping("/{id}")
    public BookingResponse editBooking(@PathVariable Long id, @RequestBody BookingEditRequest bookingEditRequest) {
        Booking booking = convertToEntity(bookingEditRequest);
        booking.setId(id);
        Booking updatedBooking = bookingService.save(booking);
        return convertToDTO(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public BookingDeleteResponse deleteBooking(@PathVariable Long id) {
        Station deletedStation = bookingService.findById(id).get().getStation();
        deletedStation.setAvailable(true);
        bookingService.deleteById(id);
        BookingDeleteResponse response = new BookingDeleteResponse();
        response.setId(id);
        response.setMessage("Booking eliminato");
        return response;
    }

    private BookingResponse convertToDTO(Booking booking) {
        BookingResponse dto = new BookingResponse();
        dto.setId(booking.getId());
        dto.setUser(booking.getUser());
        dto.setStation(booking.getStation());
        dto.setDate(booking.getDate());
        dto.setConfirmed(booking.isConfirmed());
        return dto;
    }

    private Booking convertToEntity(BookingCreateRequest dto) {
        return new Booking(dto.getUser(), dto.getStation(), dto.getDate(), dto.isOpen(), dto.isConfirmed(), dto.getGuests(), dto.getSeatsAvailable());
    }

    private Booking convertToEntity(BookingEditRequest dto) {
        return new Booking(dto.getUser(), dto.getStation(), dto.getDate(), dto.isOpen(), dto.isConfirmed(), dto.getGuests(), dto.getSeatsAvailable());
    }

    @PutMapping("/{id}/confirmation")
    public void sendEmailConfirmation(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        Optional<Admin> loggedAdmin = adminService.findLoggedin();
        String userEmail = booking.get().getUser().getEmail();
        String adminName = loggedAdmin.get().getFirstName();
        String adminEmail = loggedAdmin.get().getEmail();

        emailService.sendConfirmationEmail(userEmail, adminName, adminEmail);
    }

    @PostMapping("/boardbookingclose")
    public BookingResponse boardBookingClose(@RequestParam("date") String dateParam, @RequestParam("guests") int guests, @RequestParam("user") User user) {
        LocalDate date = LocalDate.parse(dateParam);
        Station finalBoard = null;
        List<Station> boardsList = stationService.findAvailableBoards(date);
        if (!boardsList.isEmpty()) {
            int closestDiff = Integer.MAX_VALUE;
            for (Station board : boardsList) {
                if (board.getSeatsTotal() >= guests) {
                    int diff = board.getSeatsTotal() - guests;
                    if (diff < closestDiff) {
                        closestDiff = diff;
                        finalBoard = board;
                    }
                } else {
                    throw new EntityNotFoundException("Postazione non trovata");
                }
            }
            if (finalBoard != null) {
                Booking newClosedBooking = new Booking(user, finalBoard, date, false, false, guests, finalBoard.getSeatsTotal() - guests);
                Booking newBooking = bookingService.save(newClosedBooking);
                return convertToDTO(newBooking);
            } else {
                throw new EntityNotFoundException("Postazione non trovata");
            }
        } else {
            throw new EntityNotFoundException("Postazione non trovata");
        }
    }

    @PutMapping("/{id}/boardbookingopen")
    public BookingResponse boardBookingOpen(@PathVariable Long id,
                                            @RequestParam("date") int guests,
                                            @RequestParam("user") User user,
                                            @RequestParam("date") String dateParam) {
        LocalDate date = LocalDate.parse(dateParam);

        Optional<Station> optionalBoard = stationService.findById(id);

        if (optionalBoard.isPresent()) {
            Station board = optionalBoard.get();
            List<Booking> bookingList = board.getBookingList();

            for (Booking booking : bookingList) {
                if (booking.getDate().equals(date) && booking.getSeatsAvailable() >= guests) {
                    booking.setSeatsAvailable(booking.getSeatsAvailable() - guests);
                    if (booking.getSeatsAvailable() == 0) {
                        booking.setOpen(false);
                    }


                    Booking updatedBooking = bookingService.save(booking);
                    return convertToDTO(updatedBooking);
                }
            }

            throw new EntityNotFoundException("Prenotazione non trovata per la data specificata o posti non disponibili.");

        } else {
            throw new EntityNotFoundException("Postazione non trovata");
        }
    }

    @PostMapping("/lanbooking")
    public BookingResponse lanBooking(@RequestParam("date") String dateParam,@RequestParam("userId") Long userId) {
        System.out.println(dateParam);
        System.out.println(userId);
        LocalDate date = LocalDate.parse(dateParam);
        User user = userService.findById(userId).orElseThrow(() -> new EntityNotFoundException("Utente non trovato"));
        List<Station> lansList = stationService.findAvailableLans(date);
        if (!lansList.isEmpty()) {
            Station lan = lansList.get(0);
            Booking newLanBooking = new Booking(user, lan, date, false, false, 1, 0);
            Booking newBooking = bookingService.save(newLanBooking);
            return convertToDTO(newBooking);
        } else {
            throw new EntityNotFoundException("Postazione non trovata");
        }
    }
}
