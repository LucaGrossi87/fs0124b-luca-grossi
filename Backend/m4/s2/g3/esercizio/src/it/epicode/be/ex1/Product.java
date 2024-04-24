package it.epicode.be.ex1;

public class Product {
    private long id;
    private String name, category;
    private double price;

    public Product (long id, String name, String category, double price){
        this.id=id;
        this.name=name;
        this.category=category;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double discount) {
        this.price= this.price*discount;
    }
}
