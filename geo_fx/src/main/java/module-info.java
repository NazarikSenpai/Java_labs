module org.example.geo_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.geo_fx to javafx.fxml;
    exports org.example.geo_fx;
}