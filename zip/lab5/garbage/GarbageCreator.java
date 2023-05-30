package garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static void main(String[] args) {
        String s = "";
        long start = System.currentTimeMillis();

        try {
            File myObj = new File("src/garbage/text.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                s += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
