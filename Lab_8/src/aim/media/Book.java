package aim.media;

import javax.xml.soap.Text;
import java.util.*;

public class Book extends Media implements Comparable {
    private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    public List<String> getContentTokens() {
        return contentTokens;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
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
        Book item = (Book) obj;

        char a = Character.toLowerCase(this.getTitle().charAt(0));
        char b = Character.toLowerCase(item.getTitle().charAt(0));
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            if (this.getCost() < item.getCost()) {
                return 1;
            } else if (this.getCost() > item.getCost()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private void processContent() {
        String[] tokens = content.split("[\\p{Punct}\\s]+");
        contentTokens = Arrays.asList((tokens));
        Collections.sort(contentTokens);

//        Set<String> set = new HashSet<String>(contentTokens);
//        for (String token : set) {
//            wordFrequency.put(token, Collections.frequency(contentTokens, token));
//        }

        for (String token : contentTokens) {
            Integer idx = wordFrequency.get(token);
            wordFrequency.put(token, (idx == null) ? 1 : idx + 1);
        }
    }

    public String toString() {
        return "Title: " + this.getTitle() +
                "\nCategory: " + this.getCategory() +
                "\nCost: " + this.getCost() +
                "\nAuthors: " + getStringAuthors() +
                "\nContent: " + content +
                "\nTokens:\n\t" + getStringContentTokens() +
                "\nWord Frequency:\n" + getStringWordFrequency();
    }

    private String getStringAuthors() {
        return String.join(", ", authors);
    }

    private String getStringContentTokens() {
        return String.join("\n\t", contentTokens);
    }

    private String getStringWordFrequency() {
        TreeMap<String, Integer> sorted = new TreeMap<>(wordFrequency);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            sb.append("\t" + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
