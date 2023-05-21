package aim;

import aim.media.*;
import aim.order.Order;

import java.util.Objects;
import java.util.Scanner;

public class Aims {
    private static Order currentOrder;

    public static void showMenu() {
        System.out.println("\nOrder Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add Book to the order");
        System.out.println("3. Add Digital Video Disc to the order");
        System.out.println("4. Add Compact Disc to the order");
        System.out.println("5. Delete item by id");
        System.out.println("6. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0->6");
    }

    public static Book createBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = input.nextLine();

        System.out.println("Enter cost: ");
        float cost = Float.parseFloat(input.nextLine());

        Book item = new Book(title);
        item.setCost(cost);
        return item;
    }

    public static DigitalVideoDisc createDVD() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = input.nextLine();

        System.out.println("Enter cost: ");
        float cost = Float.parseFloat(input.nextLine());

        DigitalVideoDisc item = new DigitalVideoDisc(title);
        item.setCost(cost);

        System.out.println("Play? (y/n)");
        String play = input.nextLine();
        if (Objects.equals(play, "y")) {
            item.play();
        }

        return item;
    }

    public static CompactDisc createCD() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = input.nextLine();

        System.out.println("Enter cost: ");
        float cost = Float.parseFloat(input.nextLine());

        CompactDisc item = new CompactDisc(title);
        item.setCost(cost);

        System.out.println("Enter number of tracks:");
        int nTracks = Integer.parseInt(input.nextLine());
        String trackTitle;
        int trackLen;
        for (int i = 0; i < nTracks; i++) {
            System.out.println("Enter track's title:");
            trackTitle = input.nextLine();
            System.out.println("Enter track's length:");
            trackLen = Integer.parseInt(input.nextLine());
            item.addTrack(new Track(trackTitle, trackLen));
        }

        System.out.println("Play? (y/n)");
        String play = input.nextLine();
        if (Objects.equals(play, "y")) {
            item.play();
        }
        return item;
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {

            showMenu();
            Order order;
            Scanner input = new Scanner(System.in);
            int opt = Integer.parseInt(input.nextLine());

            switch (opt) {
                case 1: {
                    currentOrder = Order.getInstance();
                    break;
                }
                case 2: {
                    currentOrder.addMedia(createBook());
                    break;
                }
                case 3: {
                    currentOrder.addMedia(createDVD());
                    break;
                }
                case 4: {
                    currentOrder.addMedia(createCD());
                    break;
                }
                case 5: {
                    int index = Integer.parseInt(input.nextLine());
                    currentOrder.removeMedia(index);
                    break;
                }
                case 6: {
                    currentOrder.summary();
                    break;
                }
                case 0: {
                    exit = true;
                    break;
                }
            }
        }
    }
}
