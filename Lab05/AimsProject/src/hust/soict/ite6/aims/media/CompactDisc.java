package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks=new ArrayList<Track>();

    // constructor
    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super(title, category, cost, director, length);
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
//    public int getLength(){
//        int l=0;
//        for(Track song: tracks){
//            l+=song.getLength();
//        }
//        return l;
//    }

    // play
    @Override
    public void play() throws PlayerException {
        // Kiểm tra thời lượng tổng của CD
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD total length: " + this.getLength());

            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play(); // Thử phát bài hát
                } catch (PlayerException e) {
                    throw e; // Nếu bài hát bị lỗi, ném lỗi đó ra ngoài cho giao diện xử lý
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $" + getArtist();
    }
}
