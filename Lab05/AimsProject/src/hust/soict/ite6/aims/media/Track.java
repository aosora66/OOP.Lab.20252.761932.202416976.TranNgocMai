package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    // constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // get
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("Cannot play track: " + this.getTitle() + " because its length is 0 or less.");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    // equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;

        Track other = (Track) obj;

        if (this.title != null && this.title.equals(other.getTitle()) && this.length == other.getLength()) {
            return true;
        }
        return false;
    }
}
