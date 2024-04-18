package it.epicode.be.ex3;

public class Volontario extends Dipendente implements Dipendente.checkIn {
    private String nome;
    private int eta;
    private String CV;

        public Volontario(String nome, int eta, String CV) {
        this.nome=nome;
        this.eta=eta;
        this.CV=CV;
    }

    public String getNome(){
            return nome;
    }

    private String checkInHour = "09:00";


    @Override
    public String getCheckInHour() {
        return checkInHour;
    }

    }
