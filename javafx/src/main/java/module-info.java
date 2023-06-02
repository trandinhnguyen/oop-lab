module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;

    opens hellojavafx to javafx.fxml;
    exports hellojavafx;

    opens flowpane to javafx.fxml;
    exports flowpane;

    opens round to javafx.fxml;
    exports round;
}