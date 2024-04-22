package it.epicode.be.ex1;

import java.util.Random;

public class RandomArray {
    private int[] randomArr= new int[5];

    public RandomArray(){
    }

    public int[] fillArray (){
        Random random = new Random();
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i]= random.nextInt(10)+1;
        }
        return randomArr;
    }

}
