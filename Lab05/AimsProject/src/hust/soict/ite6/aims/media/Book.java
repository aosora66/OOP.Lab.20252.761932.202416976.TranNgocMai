package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Them
    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Da them thanh cong!");
        }
        else System.out.println("Da ton tai tac gia.");
    }

    // Xoa
    public void removeAuthor(String authorName) throws IllegalArgumentException {
        if(authors.remove(authorName)){
            System.out.println("Da xoa thanh cong!");
        } else {
            throw new IllegalArgumentException("ERROR: Author '" + authorName + "' is not listed!");
        }
    }

    // toString
    public String toString(){
        String book = "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $ - Authors: ";
        for(String auth : authors){
            book += auth + ", ";
        }
        return book;
    }
}
