package it.epicode.be.ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args){


        List<Product> prods = new ArrayList<>();
        prods.add(new Product(1234,"Manuale del giocatore","Books",50.00));
        prods.add(new Product(1235,"Manuale del master","Books",110.00));
        prods.add(new Product(1236,"Ciuccio","Baby",10.00));
        prods.add(new Product(1237,"Culla","Baby",300.00));
        prods.add(new Product(1238,"Maglia","Boys",25.00));
        prods.add(new Product(1239,"Felpa","Boys",60.00));

        Stream<Product> books = prods.stream().filter(element -> element.getCategory().contains("Books"));;
        List<Product> expBooks = new ArrayList<>();
        double priceThreshold = 100.00;
        books.forEach(elem -> {
            if (elem.getPrice()>priceThreshold){
                expBooks.add(elem);
        }});
        logger.info("Articoli più costosi");
        expBooks.stream().forEach(elem -> {
            logger.info("Il libro " + (elem.getName()) + " costa più di " + priceThreshold);
        });
        logger.info("Prezzi scontati reparto Boys");
        Stream<Product> boys = prods.stream().filter(element -> element.getCategory().contains("Boys"));
        boys.forEach(elem -> {
            elem.setPrice(0.9);
            logger.info(String.valueOf(elem.getPrice()));
        });

        List<Customer> custs = new ArrayList<>();
        custs.add(new Customer(321, "Mario", 1));
        custs.add(new Customer(322, "Maria", 1));
        custs.add(new Customer(323, "Lucio", 2));
        custs.add(new Customer(324, "Lucia", 2));
        custs.add(new Customer(325, "Gianni", 3));
        custs.add(new Customer(326, "Gianna", 3));

        List<Order> ords = new ArrayList<>();
        ords.add(new Order(741, "shipping", LocalDate.of(2024,02,19), LocalDate.of(2024,02,23), List.of(prods.get(1),prods.get(3)),custs.get(1)));
        ords.add(new Order(742, "delivered", LocalDate.of(2024,01,19), LocalDate.of(2024,01,23), List.of(prods.get(4),prods.get(5)),custs.get(2)));
        ords.add(new Order(743, "delivered", LocalDate.of(2024,02,07), LocalDate.of(2024,02,10), List.of(prods.get(0),prods.get(3)),custs.get(3)));
        ords.add(new Order(744, "shipping", LocalDate.of(2024,02,20), LocalDate.of(2024,02,24), List.of(prods.get(4),prods.get(2)),custs.get(4)));
        ords.add(new Order(745, "delivered", LocalDate.of(2024,02,02), LocalDate.of(2024,02,05), List.of(prods.get(5),prods.get(0)),custs.get(5)));
        ords.add(new Order(746, "shipping", LocalDate.of(2024,02,18), LocalDate.of(2024,02,22), List.of(prods.get(4),prods.get(1)),custs.get(0)));

        Map<Customer, Product> babies = new HashMap<>();
        for (Order order : ords) {
            for (Product product : order.getProducts()) {
                if (product.getCategory().equals("Baby")) {
                    babies.put(order.getCustomer(), product);
                }
            }

        }
        logger.info("Ordini reparto Baby");
        for (Map.Entry<Customer, Product> entry : babies.entrySet()) {
            Customer customer = entry.getKey();
            Product product = entry.getValue();
            logger.info(customer.getName() + ", " + product.getName());
        }


        Map<Customer, Product> tier = new HashMap<>();
        for (Order order : ords) {
            if (order.getCustomer().getTier() == 2) {
                for (Product product : order.getProducts()) {
                    tier.put(order.getCustomer(), product);
                }
            }
        }
        logger.info("Ordini clienti tier 2");
        for (Map.Entry<Customer, Product> entry : tier.entrySet()) {
            Customer customer = entry.getKey();
            Product product = entry.getValue();
            logger.info(customer.getName() + ", " + product.getName());
        }


    }
}
