package it.epicode.valhallagaming.controller;

import it.epicode.valhallagaming.dto.bookingDTO.BookingCreateRequest;
import it.epicode.valhallagaming.dto.bookingDTO.BookingDeleteResponse;
import it.epicode.valhallagaming.dto.bookingDTO.BookingEditRequest;
import it.epicode.valhallagaming.dto.bookingDTO.BookingResponse;
import it.epicode.valhallagaming.entity.Admin;
import it.epicode.valhallagaming.entity.Booking;
import it.epicode.valhallagaming.entity.Station;
import it.epicode.valhallagaming.service.AdminService;
import it.epicode.valhallagaming.service.BookingService;
import it.epicode.valhallagaming.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id){
        Optional<Booking> booking = bookingService.findById(id);
        return booking.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public BookingResponse createBooking (@RequestBody BookingCreateRequest bookingCreateRequest){
        Booking booking = convertToEntity(bookingCreateRequest);
        Booking savedBooking = bookingService.save(booking);
        return convertToDTO(savedBooking);
    }

    @PutMapping ("/{id}")
    public BookingResponse editBooking (@PathVariable Long id, @RequestBody BookingEditRequest bookingEditRequest){
        Booking booking = convertToEntity(bookingEditRequest);
        booking.setId(id);
        Booking updatedBooking = bookingService.save(booking);
        return convertToDTO(updatedBooking);
    }

    @DeleteMapping ("/{id}")
    public BookingDeleteResponse deleteBooking (@PathVariable Long id){
        Station deletedStation = bookingService.findById(id).get().getStation();
        deletedStation.setAvailable(true);
        bookingService.deleteById(id);
        BookingDeleteResponse response = new BookingDeleteResponse();
        response.setId(id);
        response.setMessage("Booking eliminato");
        return response;
    }

    private BookingResponse convertToDTO (Booking booking){
        BookingResponse dto = new BookingResponse();
        dto.setId(booking.getId());
        dto.setUser(booking.getUser());
        dto.setStation(booking.getStation());
        dto.setDate(booking.getDate());
        dto.setConfirmed(booking.isConfirmed());
        return dto;
    }

    private Booking convertToEntity (BookingCreateRequest dto){
        return new Booking(dto.getUser(), dto.getStation(), dto.getDate(),dto.isConfirmed());
    }

    private Booking convertToEntity (BookingEditRequest dto){
        return new Booking(dto.getUser(), dto.getStation(), dto.getDate(),dto.isConfirmed());
    }

    @PutMapping ("/{id}/confirmation")
    public void sendEmailConfirmation (@PathVariable Long id){
        Optional<Booking> booking = bookingService.findById(id);
        Optional<Admin> loggedAdmin = adminService.findLoggedin();
        String userEmail = booking.get().getUser().getEmail();
        String adminName = loggedAdmin.get().getFirstName();
        String adminEmail = loggedAdmin.get().getEmail();

        emailService.sendConfirmationEmail(userEmail, adminName, adminEmail);
    }
    
}
