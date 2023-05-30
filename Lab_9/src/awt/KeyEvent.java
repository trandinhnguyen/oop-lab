package awt;

import java.awt.*;
import java.awt.event.*;

public class KeyEvent extends Frame {
    private TextField tfInput;
    private TextArea taDisplay;

    public KeyEvent() {
        setLayout(new FlowLayout());

        add(new Label("Enter text: "));
        tfInput = new TextField(10);
        add(tfInput);
        taDisplay = new TextArea(5, 40);
        add(taDisplay);

        tfInput.addKeyListener(new MyKeyListener());

        addWindowListener(new MyWindowListener());
        setTitle("KeyEvent");
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyEvent();
    }

    private class MyKeyListener implements KeyListener {

        public void keyTyped(java.awt.event.KeyEvent e) {
            taDisplay.append("You have typed " + e.getKeyChar() + "\n");
        }

        public void keyPressed(java.awt.event.KeyEvent e) {

        }

        public void keyReleased(java.awt.event.KeyEvent e) {

        }
    }

    private class MyWindowListener implements WindowListener {
        public void windowClosing(WindowEvent evt) {
            System.exit(0);
        }

        // Not Used, BUT need to provide an empty body to compile.
        public void windowOpened(WindowEvent evt) {
        }

        public void windowClosed(WindowEvent evt) {
        }

        // For Debugging
        public void windowIconified(WindowEvent evt) {
            System.out.println("Window Iconified");
        }

        public void windowDeiconified(WindowEvent evt) {
            System.out.println("Window Deiconified");
        }

        public void windowActivated(WindowEvent evt) {
            System.out.println("Window Activated");
        }

        public void windowDeactivated(WindowEvent evt) {
            System.out.println("Window Deactivated");
        }

    }
}
