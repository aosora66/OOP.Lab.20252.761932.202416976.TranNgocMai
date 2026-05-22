package hust.soict.ite6.aims.store;

import hust.soict.ite6.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Them
    public void addMedia (Media media){
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The media is already in the store");
        }
    }

    // Xoa
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media could not be found");
        }
    }

}
