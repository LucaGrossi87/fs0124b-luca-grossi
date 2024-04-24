package it.epicode.be.ex1;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate, deliveryDate;
    List<Product> products;
    Customer customer;

    public Order (long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer){
        this.id=id;
        this.status=status;
        this.orderDate=orderDate;
        this.deliveryDate=deliveryDate;
        this.products=products;
        this.customer=customer;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }
}
