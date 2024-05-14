package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(App.class.getResource("/form.fxml")),900,440);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//        Parent root;
//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/form.fxml")));
//        stage.setScene(new Scene(root));
//        stage.setTitle("Знайти дистанцію");
//        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}