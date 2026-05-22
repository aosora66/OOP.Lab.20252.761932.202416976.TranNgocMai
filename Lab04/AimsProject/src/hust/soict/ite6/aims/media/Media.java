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

    public void setCost(float cost) {
        this.cost = cost;
    }

    // equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;

        Media other = (Media) obj;

        if (this.title != null && this.title.equals(other.getTitle())) {
            return true;
        }
        return false;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
