package it.epicode.be.ex3;

public class Cliente {
    private String codice, nome, email, iscrizione;

    public Cliente (String codice, String nome, String email, String iscrizione){
        this.codice=codice;
        this.nome=nome;
        this.email=email;
        this.iscrizione=iscrizione;
    }

    public String getNome (){
        return nome;
    }

    public String cliente() {
        return getNome() + ", codice cliente " + codice + ", indirizzo email " + email + ", data iscrizione " + iscrizione;
    }
}
