package hellojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MyController implements Initializable {
    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showDateTime(ActionEvent e) {
        System.out.println("Button Clicked!");

        Date now = new Date();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
        myTextField.setText(dateTimeString);
    }

}