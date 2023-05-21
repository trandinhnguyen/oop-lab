package Aim;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    // hold single instance reference
    private static Order instance = null;
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>(MAX_NUMBERS_ORDERED);
    private int qtyOrdered = itemsOrdered.size();
    private String dateOrdered;

    // private constructor to avoid clients to call new on it
    private Order() {
        this.dateOrdered = getCurrentTime();
        nbOrders++;
    }

    public synchronized static Order getInstance() {
        if (nbOrders < MAX_LIMITTED_ORDERS) {
            return new Order();
        }
        return null;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(disc);
            qtyOrdered = itemsOrdered.size();
            System.out.println("The disc has been added");
        } else {
            System.out.println("The order is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(dvd1);
            itemsOrdered.add(dvd2);
            qtyOrdered = itemsOrdered.size();
            System.out.println("Two dvds has been added");
        } else {
            System.out.println("The order is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
            for (DigitalVideoDisc disc : dvdList) {
                itemsOrdered.add(disc);
            }
            qtyOrdered = itemsOrdered.size();
            System.out.println("The list of DVDS has been added");
        } else {
            System.out.println("The order is almost full");
        }
    }

    // pass an arbitrary number of arguments
    // tuy nhiên compiler coi array parameter và arbitrary arguments là một
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
//            for (DigitalVideoDisc disc : dvdList) {
//                itemsOrdered.add(disc);
//            }
//            qtyOrdered = itemsOrdered.size();
//            System.out.println("The list of DVDS has been added");
//        } else {
//            System.out.println("The order is almost full");
//        }
//    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (!itemsOrdered.isEmpty()) {
            itemsOrdered.remove(disc);
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            sum += itemsOrdered.get(i).getCost();
        }
        return sum;
    }

    public static String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    public void summary() {
        System.out.println("*********************Order*********************");
        System.out.println("Date: " + this.dateOrdered);
        System.out.println("Ordered Items: ");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemsOrdered.get(i).summary());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }
}
