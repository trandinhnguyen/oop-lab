package aim.media;

import aim.PlayerException;

import java.util.StringTokenizer;

public class DigitalVideoDisc extends Disc implements Playable, Comparable {
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public boolean search(String title) {
        String lowerTitle = this.getTitle().toLowerCase();
        StringTokenizer st = new StringTokenizer(title);

        while (st.hasMoreTokens()) {
            if (!lowerTitle.contains(st.nextToken().toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is 0");
            throw (new PlayerException());
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

//    public int compareTo(Object obj) {
//        DigitalVideoDisc item = (DigitalVideoDisc) obj;
//        char a = Character.toLowerCase(this.getTitle().charAt(0));
//        char b = Character.toLowerCase(item.getTitle().charAt(0));
//        if (a > b) {
//            return 1;
//        } else if (a < b) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

    public int compareTo(Object obj) {
        DigitalVideoDisc item = (DigitalVideoDisc) obj;
        if (this.getCost() < item.getCost()) {
            return 1;
        } else if (this.getCost() > item.getCost()) {
            return -1;
        } else {
            return 0;
        }
    }

}
