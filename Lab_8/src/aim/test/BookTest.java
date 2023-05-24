package aim.test;

import aim.media.Book;

import java.util.Map;

public class BookTest {
    public static void main(String[] args) {
        String content = "Devon couldn't figure out the color of her eyes. He initially would have guessed that" +
                " they were green, but the more he looked at them he almost wanted to say they were a golden yellow." +
                " Then there were the flashes of red and orange that seemed to be streaked throughout them." +
                " It was almost as if her eyes were made of opal with the sun constantly glinting off of them" +
                " and bringing out more color. They were definitely the most unusual pair of eyes he'd ever seen.";
        Book book = new Book("No Family");
        book.setContent(content);
//        for (String token: book.getContentTokens()) {
//            System.out.print(token + ", ");
//        }
//        for(Map.Entry<String, Integer> entry: book.getWordFrequency().entrySet()) {
//            System.out.println(entry.getKey() + ": " +entry.getValue());
//        }
        System.out.println(book.toString());
    }
}
