package hust.soict.ite6.aims.cart;

import hust.soict.ite6.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Them
    public void addMedia (Media media){
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more media.");
            return;
        }

        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The media is already in the cart");
        }
    }

    // Xoa
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media could not be found");
        }
    }

    public float totalCost(){
        float total=0;
        for(Media item : itemsOrdered) total+= item.getCost();
        return total;
    }

    // in danh sach
    public void printCart(){
        System.out.println("***********************CART***********************\nOrdered Items:");
        for(int i=0; i<itemsOrdered.size(); i++){
            System.out.println((i+1)+". "+itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: "+totalCost());
        System.out.println("***************************************************");
    }

    public void searchID(int id){
        boolean t=false;
        for(Media item : itemsOrdered){
            if(item.getId()==id) {
                t=true;
                System.out.println(item.toString());
            }
        }
        if(!t) System.out.println("Khong tim thay!");
    }
    public void searchTitle(String title){
        boolean t=false;
        for(Media item : itemsOrdered){
            if(item.getTitle().equals(title)) {
                t=true;
                System.out.println(item.toString());
            }
        }
        if(!t) System.out.println("Khong tim thay!");
    }

    // sắp xếp
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart has been sorted by title successfully.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart has been sorted by cost successfully.");
    }

}