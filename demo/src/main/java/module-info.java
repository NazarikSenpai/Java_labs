module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires javafx.graphics;


    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}