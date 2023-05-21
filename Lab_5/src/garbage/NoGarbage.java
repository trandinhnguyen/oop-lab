package garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {
    public static void main(String[] args) {
        String s = "";
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();

        try {
            File myObj = new File("src/garbage/text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start);
    }
}
