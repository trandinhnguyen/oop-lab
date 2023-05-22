package aim.test;

import aim.media.DigitalVideoDisc;
import aim.order.Order;

public class DiskTest {
    public static void main(String[] args) {

        DigitalVideoDisc disk1 = new DigitalVideoDisc("Harry and Potter is the same");
        disk1.setCost(18.5f);
        System.out.println(disk1.search("harry potter"));

        Order order = Order.getInstance();
//        order.addDigitalVideoDisc(disk1);

        DigitalVideoDisc disk2 = new DigitalVideoDisc("Hello");
        disk2.setCost(20f);
//        order.addDigitalVideoDisc(disk2);
        order.summary();
        System.out.println(order.totalCost());

        order.getALuckyItem();
        order.summary();
        System.out.println(order.totalCost());
    }
}
