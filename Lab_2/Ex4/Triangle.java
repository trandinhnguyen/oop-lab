package Ex4;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0, starCount = 1, increaseAmount = 2;

        try {
            n = input.nextInt();
        } catch (Exception e) {
            System.out.println("Must enter a int number");
        }

        for (int i = 1; i <= n; i++) {

            System.out.println(mulSpace(n - i) + mulStar(starCount));
            starCount += increaseAmount;
        }
    }

    static String mulSpace(int n) {
        String res = "";
        for (int i = 1; i <= n; i++) {
            res += " ";
        }
        return res;
    }

    static String mulStar(int n) {
        String res = "";
        for (int i = 1; i <= n; i++) {
            res += "*";
        }
        return res;
    }
}
