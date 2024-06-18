package it.epicode.valhallagaming.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "lans")
@Data
@NoArgsConstructor
public class Lan extends Station{

    public Lan(boolean available, List<Booking> bookingList){
        super(available, bookingList);
    }
}
