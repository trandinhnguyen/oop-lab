package Ex6;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        int sum = 0;
        double average = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a array in one line");

        // read input
        String str = input.nextLine();

        // split an array
        String[] strArray = str.split(" ");

        int[] array = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
            sum += array[i];
        }

        average = (double) sum / array.length;
        Arrays.sort(array);

        System.out.println("\nThe sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nSum: " + sum + "\nAverage: " + average);
    }
}
