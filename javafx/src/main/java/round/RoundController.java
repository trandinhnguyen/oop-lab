package round;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class RoundController implements Initializable {
    @FXML
    private Circle left;
    @FXML
    private Circle right;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    private void _changeColor(Circle circle) {
        if (circle.getFill() == Color.BLACK) {
            circle.setFill(Color.RED);
        } else {
            circle.setFill(Color.BLACK);
        }
    }

    public void changeColor(javafx.scene.input.MouseEvent mouseEvent) {
        left.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                _changeColor(left);
                _changeColor(right);
            }
        });
        right.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                _changeColor(left);
                _changeColor(right);
            }
        });
    }
}
