package aim;

import aim.media.DigitalVideoDisc;
import aim.media.Media;
import aim.order.Order;

import java.util.Scanner;

public class Aims {
    private static Order currentOrder;

    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static Media createItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = input.nextLine();

        System.out.println("Enter cost: ");
        float cost = input.nextFloat();

        Media item = new Media(title);
        item.setCost(cost);
        return item;
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {

            showMenu();
            Order order;
            Scanner input = new Scanner(System.in);
            int opt = input.nextInt();

            switch (opt) {
                case 1: {
                    currentOrder = Order.getInstance();
                    break;
                }
                case 2: {
                    currentOrder.addMedia(createItem());
                    break;
                }
                case 3: {
                    int index = input.nextInt();
                    currentOrder.removeMedia(index);
                    break;
                }
                case 4: {
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
