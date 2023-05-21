import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "First number", "Input", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null, "Second number", "Input", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        String sum = Double.toString(num1 + num2);
        String difference = Double.toString(num1 - num2);
        String product = Double.toString(num1 * num2);
        String quotient;

        if (num2 == 0) {
            quotient = "Divided by 0";

        } else {
            quotient = Double.toString(num1 / num2);
        }

        String result = "Sum: " + sum
                + "\nDifference: " + difference
                + "\nProduct: " + product
                + "\nQuotient: " + quotient;

        JOptionPane.showMessageDialog(null, result, "Calculator", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
