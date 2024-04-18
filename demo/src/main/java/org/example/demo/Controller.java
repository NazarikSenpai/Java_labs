package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {

    public TextField latitudeTextField;
    public TextField longitudeTextField;
    @FXML
    private TableColumn<?, ?> cityColumn;

    @FXML
    private TextField cityField;

    @FXML
    private Label cityLabel;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TextField idField;

    @FXML
    private Label idLabel;

    @FXML
    private Button insertButton;

    @FXML
    private TableColumn<?, ?> latitudeColumn;

    @FXML
    private TextField latitudeLabel;

    @FXML
    private AnchorPane leftPane;

    @FXML
    private TableColumn<?, ?> longitudeColumn;

    @FXML
    private TextField longitudeLabel;

    @FXML
    private Label photoLabel;

    @FXML
    private TableView<?> table;

    @FXML
    private AnchorPane tablePane;

    @FXML
    private Button updateButton;

}
