package aim.media;

import aim.PlayerException;

public class Track implements Playable, Comparable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is 0");
            throw (new PlayerException());
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public int compareTo(Object obj) {
        Track item = (Track) obj;
        char a = Character.toLowerCase(this.getTitle().charAt(0));
        char b = Character.toLowerCase(item.getTitle().charAt(0));
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}
