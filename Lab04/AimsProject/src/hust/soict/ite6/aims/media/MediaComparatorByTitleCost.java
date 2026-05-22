package hust.soict.ite6.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Sắp xếp title theo thứ tự bảng chữ cái
        int titleCompare = m1.getTitle().compareTo(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }
}