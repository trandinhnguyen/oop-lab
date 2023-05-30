package aim;

import aim.disc.DigitalVideoDisc;
import aim.order.Order;

public class Aims {
    public static void main(String[] args) {
        // ***********************
        // ORDER 1
        // ***********************
        Order order1 = Order.getInstance();

        // Create a new dvd object and set the fields
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        // add the dvd to the order
        order1.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);
        order1.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        order1.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost before removal is: " + order1.totalCost());
        order1.removeDigitalVideoDisc(dvd1);
        order1.removeDigitalVideoDisc(dvd3);
        System.out.println("Total cost after removal is: " + order1.totalCost());


        // ***********************
        // ORDER 2
        // ***********************
        System.out.println();
        Order order2 = Order.getInstance();
        DigitalVideoDisc dvd21 = new DigitalVideoDisc("acs", "catcxe", "directbaor", 5, 4.5f);
        DigitalVideoDisc dvd22 = new DigitalVideoDisc("asdg", "gas", "dicarector", 1, 10.57f);
        DigitalVideoDisc dvd23 = new DigitalVideoDisc("hsffb", "hsfb");
        order2.addDigitalVideoDisc(dvd21, dvd22, dvd23);
        order2.summary();

        // ***********************
        // Create other orders
        // ***********************
        System.out.println();
        Order order3 = Order.getInstance();
        Order order4 = Order.getInstance();
        Order order5 = Order.getInstance();
        // Exceeding
        Order order6 = Order.getInstance();
        try {
            order6.addDigitalVideoDisc(dvd21, dvd22, dvd23);
            order6.summary();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}