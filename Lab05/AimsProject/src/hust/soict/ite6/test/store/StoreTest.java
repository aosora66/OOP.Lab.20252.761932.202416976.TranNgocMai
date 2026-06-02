package hust.soict.ite6.test.store;

import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store mai=new Store();

        DigitalVideoDisc dvd1= new DigitalVideoDisc("3月のライオン", "Animation", "Akiyuki Shinbo", 66, 22.22f);
        mai.addMedia(dvd1);

        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);


        DigitalVideoDisc dvd3 = new DigitalVideoDisc("葬送のフリーレン", "Animation", "Keiichirou Saitou", 99, 66.66f);


        DigitalVideoDisc dvd4= new DigitalVideoDisc("Aladin", "Animation", "Roger Allers",18.99f);

    }
}
