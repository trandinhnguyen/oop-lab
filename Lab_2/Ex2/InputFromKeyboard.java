package Ex2;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("what's your name");
        String strName = keyboard.nextLine();
        System.out.println("how old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("how tall are you?");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mrs/Mr. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");
    }
}
