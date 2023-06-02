package awt;

import java.awt.*; // Using AWT container and component classes
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.util.Timer;
import java.util.TimerTask;

// An AWT program inherits from the top-level container java.awt.Frame
public class AWTCounter extends Frame {
    private Label lblCount;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;

    public AWTCounter() {
        // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
        // the components from left-to-right, and flow to next row from top-to-bottom.
        setLayout(new FlowLayout());

        lblCount = new Label("Counter");
        add(lblCount); // "super" Frame container adds Label component

        tfCount = new TextField(count + "", 10);
        tfCount.setEditable(false);
        add(tfCount);

        btnCount = new Button("Count");
        add(btnCount);
        // "btnCount" is the source object that fires an ActionEvent when clicked.
        // The source add "this" instance as an ActionEvent listener, which provides
        //   an ActionEvent handler called actionPerformed().
        // Clicking "btnCount" invokes actionPerformed().
        btnCount.addMouseListener(new BtnCountListener());

        addWindowListener(new MyWindowListener());

        setTitle("AWT Counter");
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        AWTCounter app = new AWTCounter();
    }

    // Define an inner class to handle ActionEvent of btnCount
    private class BtnCountListener implements MouseListener {
        private int eventCnt = 0;
        java.util.Timer timer = new java.util.Timer("doubleClickTimer", false);

        public void actionPerformed(ActionEvent evt) {
//            if evt.get
            // Convert int to String
        }


        public void mouseClicked(MouseEvent e) {

            eventCnt = e.getClickCount();
            if (e.getClickCount() == 1) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (eventCnt == 1) {
//                            System.err.println("You did a single click.");
                            count++;
                            tfCount.setText(count + "");
                        } else if (eventCnt > 1) {
//                            System.err.println("you clicked " + eventCnt + " times.");
                            count--;
                            tfCount.setText(count + "");
                        }
                        eventCnt = 0;
                    }
                }, 400);
            }
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    // Define an inner class to handle WindowEvent of this Frame
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
