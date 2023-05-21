package Ex7;

import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the shape of matrix in 1 line:");

        String strShape = input.nextLine();
        int[] shape = strToIntArray(strShape);

        double[][] matrix1 = new double[shape[0]][shape[1]];
        double[][] matrix2 = new double[shape[0]][shape[1]];

        System.out.println("\nEnter the first matrix (each row in 1 line)");
        for (int i = 0; i < shape[1]; i++) {
            String row = input.nextLine();
            matrix1 = buildMatrix(matrix1, row, i);
        }

        System.out.println("\nEnter the second matrix (each row in 1 line)");
        for (int i = 0; i < shape[1]; i++) {
            String row = input.nextLine();
            matrix2 = buildMatrix(matrix2, row, i);
        }

        System.out.println("\nSum of 2 matrix:");
        printMatrix(addMatrix(matrix1, matrix2));
    }

    static void printMatrix(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (double num : matrix[row]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static double[][] addMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] sum = new double[matrix1.length][matrix1[0].length];

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                sum[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }
        return sum;
    }

    static double[][] buildMatrix(double[][] matrix, String strRow, int rowIndex) {
        double[] row = strToDoubleArray(strRow);
        for (int i = 0; i < row.length; i++) {
            matrix[rowIndex][i] = row[i];
        }
        return matrix;
    }

    static double[] strToDoubleArray(String str) {
        String[] strArray = str.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    static int[] strToIntArray(String str) {
        String[] strArray = str.split(" ");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }
}
