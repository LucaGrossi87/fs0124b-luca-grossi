package it.epicode.be.ex1;

public class NumberOutOfBoundException extends Exception{
    public NumberOutOfBoundException (String message){
        super (message);
    }
    public NumberOutOfBoundException(){
    }
}
