package it.epicode.valhallagaming.service;

import it.epicode.valhallagaming.entity.Booking;
import it.epicode.valhallagaming.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking save (Booking booking){
        return bookingRepository.save(booking);
    }

    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getByDate(LocalDate date){
        return bookingRepository.findBookingsByDate(date);
    }

}
