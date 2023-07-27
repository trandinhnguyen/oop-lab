package aim;

import aim.media.*;
import aim.order.Order;

import java.util.*;

public class Aims {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("I do");
        try {
            dvd1.play();
        } catch (PlayerException e) {
            e.printStackTrace();
            e.getMessage();
            e.toString();
        }

        CompactDisc cd = new CompactDisc("Album");
        try {
            cd.play();
        } catch (PlayerException e) {
            e.printStackTrace();
        }
    }
}
