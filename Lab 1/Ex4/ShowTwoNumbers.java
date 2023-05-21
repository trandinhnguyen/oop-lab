import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You're just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "First number", "Input", JOptionPane.INFORMATION_MESSAGE);

        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "Second number", "Input", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}