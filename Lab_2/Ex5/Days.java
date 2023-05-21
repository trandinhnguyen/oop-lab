package Ex5;

import java.util.Scanner;

public class Days {
    public static void main(String[] args) {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter month and year: ");
            int month = 0, year = 0;

            try {
                month = input.nextInt();
                if (!checkValid(month)) {
                    System.out.println("Not a valid month\n");
                    continue;
                }

                year = input.nextInt();
            } catch (Exception e) {
                System.out.println("Not a valid value\n");
                continue;
            }

            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("31 days");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("30 days");
                    break;
                case 2:
                    if (checkLeapYear(year)) {
                        System.out.println("29 days");
                    } else {
                        System.out.println("28 days");
                    }
                    break;
            }

            // exit while loop
            break;
        }
    }

    static boolean checkValid(int month) {
        if (1 <= month && month <= 12) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkLeapYear(int year) {
        year = Math.abs(year);
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
