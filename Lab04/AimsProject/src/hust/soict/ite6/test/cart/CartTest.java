package hust.soict.ite6.test.cart;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart=new Cart();
        DigitalVideoDisc dvd1= new DigitalVideoDisc("3月のライオン", "Animation", "Akiyuki Shinbo", 66, 22.22f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("葬送のフリーレン", "Animation", "Keiichirou Saitou", 99, 66.66f);
        cart.addMedia(dvd3);

        DigitalVideoDisc dvd4= new DigitalVideoDisc("Aladin", "Animation", "Roger Allers",18.99f);
        cart.addMedia(dvd4);

        cart.printCart();
        cart.searchID(6);
        cart.searchTitle("3月のライオン");
    }
}
