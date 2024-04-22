package it.epicode.be.ex1;

public class PositionOutOfBoundException extends Throwable {
    public PositionOutOfBoundException (String message){
        super (message);
    }
    public PositionOutOfBoundException(){
    }
}
