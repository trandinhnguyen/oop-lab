package aim;

import aim.media.*;
import aim.order.Order;

import java.util.*;

public class Aims {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("the lion king");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("aladdin");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("star wars");
        dvd1.setCost(20f);
        dvd2.setCost(30f);
        dvd3.setCost(10f);

        List<DigitalVideoDisc> collection = new ArrayList<DigitalVideoDisc>();

        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);


        Iterator iterator = collection.iterator();

        System.out.println("---------------------");
        System.out.println("The list in current order:");

        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        Collections.sort((List) collection);

        iterator = collection.iterator();

        System.out.println("---------------------");
        System.out.println("The list in sorted order:");

        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        System.out.println("---------------------");
    }
}
