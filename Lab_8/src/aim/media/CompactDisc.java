package aim.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable, Comparable {
    private String artist;
    private int length = 0;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, ArrayList<Track> tracks) {
        super(title);
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track already exist");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("This track doesn't exist");
        }
    }

    public int getLength() {
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public void play() {
        for (Track track : tracks) {
            track.play();
        }
    }

    public int compareTo(Object obj) {
        CompactDisc cd = (CompactDisc) obj;
        if (this.getTitle() == cd.getTitle()) {
            return 1;
        } else {
            return 0;
        }
    }
}
