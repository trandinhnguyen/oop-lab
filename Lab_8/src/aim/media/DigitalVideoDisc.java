package aim.media;

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
            if (lowerTitle.indexOf(st.nextToken().toLowerCase()) == -1) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public int compareTo(Object obj) {
        DigitalVideoDisc dvd = (DigitalVideoDisc) obj;
        if (this.getTitle() == dvd.getTitle()) {
            return 1;
        } else {
            return 0;
        }
    }

}
