package aim.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media implements Comparable {
    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, List<String> authors) {
        super(title, category);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("This author is already exist");
        } else {
            authors.add(authorName);
            System.out.println("Added author");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author");

        } else {
            System.out.println("This author doesn't exist");
        }
    }

    public int compareTo(Object obj) {
        Book book = (Book) obj;
        if (this.getTitle() == book.getTitle()) {
            return 1;
        } else {
            return 0;
        }
    }
}
