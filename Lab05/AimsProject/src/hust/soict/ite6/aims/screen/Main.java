package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Track;
import hust.soict.ite6.aims.store.Store;

public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo một Cửa hàng (Store)
        Store store = new Store();

        // 2. Tạo các sản phẩm test cậu đã chuẩn bị
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("3月のライオン", "Animation", "Akiyuki Shinbo", 66, 22.22f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("葬送のフリーレン", "Animation", "Keiichirou Saitou", 99, 66.66f);

        Book book1 = new Book(10, "Harry Potter", "Fantasy", 15.50f);
        book1.addAuthor("J.K. Rowling");

        CompactDisc cd1 = new CompactDisc(20, "Adele 21", "Music", 20.0f, "Sony Music", 45, "Adele");
        Track track1 = new Track("Rolling in the Deep", 4);
        Track track2 = new Track("Someone Like You", 5);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        // 3. Nạp toàn bộ sản phẩm vào Store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);

        // test
        DigitalVideoDisc errorDvd = new DigitalVideoDisc("Lỗi đĩa", "Animation", "Test", 0, 10.0f); // Length = 0
        store.addMedia(errorDvd);

        // 4. Khởi chạy Màn hình chính của Cửa hàng
        new StoreScreen(store);
    }
}