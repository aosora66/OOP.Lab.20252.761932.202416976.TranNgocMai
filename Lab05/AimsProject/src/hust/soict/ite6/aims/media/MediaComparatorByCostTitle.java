package hust.soict.ite6.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Sắp xếp giá theo thứ tự giảm dần (m2 trước m1)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        return m1.getTitle().compareTo(m2.getTitle());
    }
}