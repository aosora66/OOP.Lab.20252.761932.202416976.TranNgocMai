package hust.soict.ite6.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // constructor
    public Media(){};

    public Media(int id, String title, String category, float cost) {
        this.id=id;
        this.title=title;
        this.category=category;
        this.cost=cost;
    }

    public String toString(){
        return "Media - "+title+" - "+category+" - " +cost+" $";
    }

    // get set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) throws IllegalArgumentException {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("ERROR: Cost cannot be negative!");
        }
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // === XỬ LÝ SO SÁNH EQUALS ===
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra xem có trỏ đến cùng một ô nhớ không (tối ưu hóa)
        if (this == obj) {
            return true;
        }

        //  Kiểm tra lỗi NullPointerException và ClassCastException
        if (!(obj instanceof Media)) {
            return false;
        }

        Media otherMedia = (Media) obj;

        // So sánh tiêu đề (Title)
        if (this.getTitle() != null && otherMedia.getTitle() != null) {
            return this.getTitle().equals(otherMedia.getTitle());
        }

        return false;
    }
}
