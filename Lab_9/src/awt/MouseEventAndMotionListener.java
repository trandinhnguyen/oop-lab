package awt;

import java.awt.*;
import java.awt.event.*;

public class MouseEventAndMotionListener extends Frame {
    private TextField tfMouseClickX;
    private TextField tfMouseClickY;
    private TextField tfMousePositionX;
    private TextField tfMousePositionY;

    public MouseEventAndMotionListener() {
        setLayout(new FlowLayout());

        add(new Label("X-Click: "));

        tfMouseClickX = new TextField(10);
        tfMouseClickX.setEditable(false);
        add(tfMouseClickX);
        add(new Label("Y-Click: "));
        tfMouseClickY = new TextField(10);
        tfMouseClickY.setEditable(false);
        add(tfMouseClickY);

        add(new Label("X-Position: "));
        tfMousePositionX = new TextField(10);
        tfMousePositionX.setEditable(false);
        add(tfMousePositionX);
        add(new Label("Y-Position: "));
        tfMousePositionY = new TextField(10);
        tfMousePositionY.setEditable(false);
        add(tfMousePositionY);

        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

        addWindowListener(new MyWindowListener());
        setTitle("Mouse Event and Motion Listener");
        setSize(400, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventAndMotionListener();
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            tfMouseClickX.setText(e.getX() + "");
            tfMouseClickY.setText(e.getY() + "");
        }

        public void mousePressed(java.awt.event.MouseEvent e) {

        }

        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        public void mouseExited(java.awt.event.MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {
            tfMousePositionX.setText(e.getX() + "");
            tfMousePositionY.setText(e.getY() + "");
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
