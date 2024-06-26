//package it.epicode.valhallagaming.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@DiscriminatorValue("BOARD")
//@Entity
//@NoArgsConstructor
//public class Board extends Station {
//    @Column(nullable = false)
//    private int seatsTotal;
//    @Column(nullable = false)
//    private int seatsAvailable;
//    @Column(nullable = false)
//    private boolean open=false;
//
//    public Board (boolean available, List<Booking> bookingList, int seatsTotal, int seatsAvailable, boolean open){
//        super(available,bookingList);
//        this.seatsTotal=seatsTotal;
//        this.seatsAvailable=seatsAvailable;
//        this.open=open;
//    }
//}
