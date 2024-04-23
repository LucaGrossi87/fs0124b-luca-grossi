package it.epicode.be.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ordinata {
    int n;

    public Ordinata(int n) {
        this.n = n;
    }

    public List<Integer> newOrd() {
        Random rand = new Random();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int randomNumber = rand.nextInt(101);
            resultList.add(randomNumber);
        }
        Collections.sort(resultList);
        return resultList;
    }
}
