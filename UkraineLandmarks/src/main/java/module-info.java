module group.ukrainelandmarks {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens group.ukrainelandmarks to javafx.fxml;
    exports group.ukrainelandmarks;
}