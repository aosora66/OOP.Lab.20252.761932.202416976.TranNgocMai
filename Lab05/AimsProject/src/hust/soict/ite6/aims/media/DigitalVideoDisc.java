package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;

    // constructor
    public DigitalVideoDisc(String title) {
        super(0, title, null, 0.0f, null, 0);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(0, title, category, cost, null, 0);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(0, title, category, cost, director, 0);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost, director, length);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public String toString(){
        return "DVD - "+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+": "+getCost()+" $";
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
