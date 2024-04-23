package it.epicode.be.ex2;

import java.util.Collections;
import java.util.List;

public class Inverso {
    List<Integer> ord;

    public Inverso (List<Integer> ord){
        this.ord=ord;
    }

    public List<Integer> newInv(List<Integer> ord) {
        Collections.reverse(ord);
        return ord;
    }

}
