module co.edu.uniquindio.poo.patronstate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;


    opens co.edu.uniquindio.poo.patronstate to javafx.fxml;
    opens co.edu.uniquindio.poo.patronstate.ViewController to javafx.fxml;

    opens co.edu.uniquindio.poo.patronstate.Model to javafx.base;

    exports co.edu.uniquindio.poo.patronstate;
    exports co.edu.uniquindio.poo.patronstate.ViewController;
    exports co.edu.uniquindio.poo.patronstate.Model;
}