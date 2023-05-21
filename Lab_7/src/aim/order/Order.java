package aim.order;

import aim.media.Media;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    // hold single instance reference
    private static Order instance = null;
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private static int nbOrders = 0;
    private int orderId;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    private String dateOrdered;

    // private constructor to avoid clients to call new on it
    private Order() {
        this.dateOrdered = getCurrentTime();
        nbOrders++;
        this.orderId = nbOrders;
    }

    public synchronized static Order getInstance() {
        if (nbOrders < MAX_LIMITED_ORDERS) {
            return new Order();
        }
        return null;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The order is full");
        } else {
            itemsOrdered.add(media);
        }
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.isEmpty()) {
            itemsOrdered.remove(media);
        }
    }

    public void removeMedia(int index) {
        if(!itemsOrdered.isEmpty()) {
            itemsOrdered.remove(index);
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
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println("ID: " + i + ". " + itemsOrdered.get(i).summary());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }

    public Media getALuckyItem() {
        int luckyIdx = (int) (Math.random() * itemsOrdered.size());
        itemsOrdered.get(luckyIdx).setCost(0.0f);
        return itemsOrdered.get(luckyIdx);
    }
}
