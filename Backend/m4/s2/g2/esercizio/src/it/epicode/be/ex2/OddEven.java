package it.epicode.be.ex2;

import java.util.ArrayList;
import java.util.List;

public class OddEven {
    List<Integer> ord;
    boolean even;

    public OddEven (List<Integer> ord, boolean even){
        this.ord=ord;
        this.even=even;
    }

    public List<Integer> oddOrEven(List<Integer> ord, boolean even) {
        List<Integer> evens = new ArrayList<>();
        if (even) {
            for (int i = 0; i < ord.size(); i++) {
                if (i % 2 == 0) {
                    evens.add(ord.get(i));
                }
            }
        } else {
            for (int i = 0; i < ord.size(); i++) {
                if (i % 2 != 0) {
                    evens.add(ord.get(i));
                }
            }
        }
        return evens;
    }
}
