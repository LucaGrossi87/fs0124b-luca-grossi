package it.epicode.be.ex3;

public class Main {
    public static void main (String[] args){
        Articolo art1 = new Articolo ("123456", "iphone", 900, 7);
        Articolo art2 = new Articolo ("654321", "smartTv", 500, 12);
        Articolo art3 = new Articolo ("741852", "monopattino", 350, 9);
        System.out.println(art1.articolo());
        System.out.println(art2.articolo());
        System.out.println(art3.articolo());
        Cliente cl1 = new Cliente("456789", "Mario Rossi","mario@rossi.it","06/06/86");
        Cliente cl2 = new Cliente("987654", "Gianni Bianchi","gianni@bianchi.it","06/06/96");
        System.out.println(cl1.cliente());
        System.out.println(cl2.cliente());
        Carrello cart1 = new Carrello(cl1, new Articolo[]{art1});
        Carrello cart2 = new Carrello(cl2, new Articolo[]{art2,art3});
        System.out.println(cart1.Conto());
        System.out.println(cart2.Conto());
    }
}
