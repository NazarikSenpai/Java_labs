module test.ucraine_landmarks {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.ucraine_landmarks to javafx.fxml;
    exports test.ucraine_landmarks;
}