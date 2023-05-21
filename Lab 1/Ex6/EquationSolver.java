package Ex6;

import java.util.Scanner;
import java.lang.Math;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a corresponding number:" +
                "\n1. The first degree equation with one variable" +
                "\n2. The first degree equation with two variables" +
                "\n3. The second degree equation with one variable");

        int mode = 0;
        try {
            mode = myObj.nextInt();
        } catch (Exception e) {
            System.out.println("Must enter a natural number");
        }

        switch (mode) {
            case 1:
                solver1();
                break;
            case 2:
                solver2();
                break;
            case 3:
                solver3();
                break;
            default:
                System.out.println("Wrong corresponding number");
        }

    }

    static void solver1() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEquation ax + b = 0. Enter a, b in two lines:");
        double a = 0, b = 0;
        String result;

        try {
            a = myObj.nextDouble();
            b = myObj.nextDouble();
        } catch (Exception e) {
            System.out.println("Must enter a number");
            System.exit(0);
        }

        if (a == 0) {
            result = "Infinity solutions";
        } else {
            result = Double.toString(-b / a);
        }
        System.out.println("Result: " + result);
    }

    static void solver2() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEquation a1x + b1y + c1 = 0, a2x + b2y + c2 = 0. Enter these coefs in six lines:");
        double a1 = 0, b1 = 0, c1 = 0, a2 = 0, b2 = 0, c2 = 0;
        String result;

        try {
            a1 = myObj.nextDouble();
            b1 = myObj.nextDouble();
            c1 = myObj.nextDouble();
            a2 = myObj.nextDouble();
            b2 = myObj.nextDouble();
            c2 = myObj.nextDouble();
        } catch (Exception e) {
            System.out.println("Must enter a number");
            System.exit(0);
        }

        double denominator = a1 * b2 - a2 * b1;
        if (denominator == 0) {
            if (a1 * c2 - a2 * c1 == 0) {
                result = "PT vo so nghiem (Infinity solutions)";
            } else {
                result = "PT vo nghiem (No solution)";
            }
        } else {
            double x = -(b2 * c1 - b1 * c2) / denominator;
            double y = (a2 * c1 - a1 * c2) / denominator;
            result = "x: " + x + ", y: " + y;
        }
        System.out.println("Result: " + result);
    }

    static void solver3() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nEquation ax^2 + bx + c = 0. Enter a, b, c in three lines:");
        double a = 0, b = 0, c = 0;
        double delta = 0;
        String result;

        try {
            a = myObj.nextDouble();
            b = myObj.nextDouble();
            c = myObj.nextDouble();
        } catch (Exception e) {
            System.out.println("Must enter a number");
            System.exit(0);
        }

        delta = b * b - 4 * a * c;

        if (delta < 0) {
            result = "PT vo nghiem (No solution)";
        } else if (delta == 0) {
            result = "x: " + (-b / (2 * a));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            result = "x1: " + x1 + ", x2: " + x2;
        }
        System.out.println("Result: " + result);
    }
}
