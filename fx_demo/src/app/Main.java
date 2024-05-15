package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Form.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(new Scene(root));
        stage.setTitle("Знайти дистанцію");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
