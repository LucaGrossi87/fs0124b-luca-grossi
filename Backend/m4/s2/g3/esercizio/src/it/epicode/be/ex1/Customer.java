package it.epicode.be.ex1;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer (long id, String name, int tier){
        this.id=id;
        this.name=name;
        this.tier=tier;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }
}
