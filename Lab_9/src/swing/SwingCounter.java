package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingCounter extends JFrame {

    private JTextField tfCount;
    private JButton btnCount;
    private int count = 0;

    public SwingCounter() {
        // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
        // the components from left-to-right, and flow to next row from top-to-bottom.
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        cp.add(new JLabel("Counter"));

        tfCount = new JTextField("0", 10);
        tfCount.setEditable(false);
        cp.add(tfCount);

        btnCount = new JButton("Count");
        cp.add(btnCount);
        // "btnCount" is the source object that fires an ActionEvent when clicked.
        // The source add "this" instance as an ActionEvent listener, which provides
        //   an ActionEvent handler called actionPerformed().
        // Clicking "btnCount" invokes actionPerformed().
//        btnCount.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                count++;
//                tfCount.setText(count + "");
//            }
//        });

        btnCount.addActionListener(e -> tfCount.setText(++count + ""));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swing Counter");
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI construction in the Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingCounter();
            }
        });
    }
}
