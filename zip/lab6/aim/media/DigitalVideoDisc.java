package aim.media;

import java.util.StringTokenizer;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
}
