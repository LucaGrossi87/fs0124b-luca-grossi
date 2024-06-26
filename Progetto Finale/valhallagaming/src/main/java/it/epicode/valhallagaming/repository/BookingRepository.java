package it.epicode.valhallagaming.repository;

import it.epicode.valhallagaming.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
