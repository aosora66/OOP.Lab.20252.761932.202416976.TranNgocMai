package hust.soict.ite6.aims;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.exception.LimitExceededException;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.media.*;

import hust.soict.ite6.aims.media.*;
import hust.soict.ite6.aims.store.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    private static Scanner sc = new Scanner(System.in);

    // Khởi tạo Store và Cart dùng chung cho toàn bộ ứng dụng
    private static Store store = new Store();
    private static Cart cart = new Cart();

    private static ArrayList<Media> itemsInStoreList = new ArrayList<Media>();

    public static void main(String[] args) throws LimitExceededException, PlayerException {

        DigitalVideoDisc dvd1= new DigitalVideoDisc("3月のライオン", "Animation", "Akiyuki Shinbo", 66, 22.22f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("葬送のフリーレン", "Animation", "Keiichirou Saitou", 99, 66.66f);

        Book book1 = new Book(10, "Harry Potter", "Fantasy", 15.50f);
        book1.addAuthor("J.K. Rowling");

        CompactDisc cd1 = new CompactDisc(20, "Adele 21", "Music", 20.0f, "Sony Music", 45, "Adele");
        Track track1 = new Track("Rolling in the Deep", 4);
        Track track2 = new Track("Someone Like You", 5);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        // Thêm vào Store
        store.addMedia(dvd1); itemsInStoreList.add(dvd1);   cart.addMedia(dvd1);
        store.addMedia(dvd2); itemsInStoreList.add(dvd2);
        store.addMedia(book1); itemsInStoreList.add(book1); cart.addMedia(book1);
        store.addMedia(cd1);  itemsInStoreList.add(cd1);
        System.out.println("--- Store pre-populated with sample data --- \n");

        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ ký tự xuống dòng còn sót lại

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again (0-3).");
            }
        } while (choice != 0);
    }

    // menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    // view store
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    // See a media's details
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    // see current cart
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // 1. View store
    private static void viewStore() throws LimitExceededException, PlayerException {
        System.out.println("\n--- ITEMS IN STORE ---");
        for (Media m : itemsInStoreList) {
            System.out.println(m.toString());
        }
        System.out.println("----------------------");

        int choice;
        do {
            storeMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // See details
                    System.out.print("Enter the title of the media: ");
                    String title = sc.nextLine();
                    Media foundMedia = findMediaByTitleInStore(title);
                    if (foundMedia != null) {
                        System.out.println(foundMedia.toString());
                        handleMediaDetailsMenu(foundMedia);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2: // Add to cart
                    System.out.print("Enter the title of the media to add to cart: ");
                    String tAdd = sc.nextLine();
                    Media mAdd = findMediaByTitleInStore(tAdd);
                    if (mAdd != null) {
                        cart.addMedia(mAdd);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter the title of the media to play: ");
                    String tPlay = sc.nextLine();
                    Media mPlay = findMediaByTitleInStore(tPlay);
                    playMedia(mPlay);
                    break;
                case 4: // See current cart
                    seeCurrentCart();
                    break;
                case 0: // Back
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0 && choice != 4);
    }

    // Chi tiết con của See Details
    private static void handleMediaDetailsMenu(Media media) throws LimitExceededException, PlayerException {
        int choice;
        do {
            mediaDetailsMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    // 2. Update Store
    private static void updateStore() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Choose option: ");
        int opt = sc.nextInt();
        sc.nextLine();

        if (opt == 1) {
            System.out.print("Enter media title to add: ");
            String title = sc.nextLine();
            System.out.print("Enter category: ");
            String cat = sc.nextLine();
            System.out.print("Enter cost: ");
            float cost = sc.nextFloat();
            sc.nextLine();

            // Mặc định tạo dưới dạng DVD để test nhanh
            DigitalVideoDisc newDvd = new DigitalVideoDisc(title, cat, cost);
            store.addMedia(newDvd);
            itemsInStoreList.add(newDvd);
        } else if (opt == 2) {
            System.out.print("Enter media title to remove: ");
            String title = sc.nextLine();
            Media m = findMediaByTitleInStore(title);
            if (m != null) {
                store.removeMedia(m);
                itemsInStoreList.remove(m);
            } else {
                System.out.println("Media not found in store.");
            }
        }
    }

    // 3. See Current Cart
    private static void seeCurrentCart() throws PlayerException {
        cart.printCart();
        int choice;
        do {
            cartMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Filter
                    System.out.println("Filter options: 1. By ID  2. By Title");
                    int fOpt = sc.nextInt();
                    sc.nextLine();
                    if (fOpt == 1) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        cart.searchID(id);
                    } else {
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        cart.searchTitle(title);
                    }
                    break;
                case 2: // Sort (Mục 12)
                    System.out.println("Sort options: 1. By Title  2. By Cost");
                    int sOpt = sc.nextInt();
                    sc.nextLine();
                    if (sOpt == 1) {
                        cart.sortByTitle();
                        cart.printCart();
                    } else {
                        cart.sortByCost();
                        cart.printCart();
                    }
                    break;
                case 3: // Remove
                    System.out.print("Enter title to remove from cart: ");
                    String rTitle = sc.nextLine();
                    // Để xóa bằng hàm removeMedia(Media), ta tìm đối tượng tương ứng từ store/danh sách mẫu
                    Media rMedia = findMediaByTitleInStore(rTitle);
                    if (rMedia != null) {
                        cart.removeMedia(rMedia);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4: // Play
                    System.out.print("Enter title to play from cart: ");
                    String pTitle = sc.nextLine();
                    Media pMedia = findMediaByTitleInStore(pTitle);
                    playMedia(pMedia);
                    break;
                case 5: // Place Order
                    System.out.println("An order has been created successfully!");
                    // Làm trống giỏ hàng bằng cách tạo lại thực thể mới
                    cart = new Cart();
                    System.out.println("Your cart is now empty.");
                    choice = 0; // Thoát ra menu chính sau khi đặt hàng thành công
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static Media findMediaByTitleInStore(String title) {
        for (Media m : itemsInStoreList) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    private static void playMedia(Media media) throws PlayerException {
        if (media == null) {
            System.out.println("Media not found to play!");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media type (" + media.getClass().getSimpleName() + ") cannot be played.");
        }
    }
}
