package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks=new ArrayList<Track>();

    // constructor
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    // Them
    public void addTrack(Track song){
        if(!tracks.contains(song)){
            tracks.add(song);
            System.out.println("Da them thanh cong!");
        }
        else System.out.println("Da ton tai bai hat.");
    }

    // Xoa
    public void removeTrack(Track song){
        if(tracks.remove(song)){
            System.out.println("Da xoa thanh cong!");
        }
        else System.out.println("Khong ton tai bai hat.");
    }
    
    // length
    public int getLength(){
        int l=0;
        for(Track song: tracks){
            l+=song.getLength();
        }
        return l;
    }

    // play
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD total length: " + this.getLength());

            // Lặp qua từng bài hát và phát
            for (Track song : tracks) {
                song.play(); // Gọi hàm play() của lớp Track
            }
        } else {
            System.out.println("Cannot play CD: " + this.getTitle() + " because its length is 0 or less.");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $" + getArtist();
    }
}
