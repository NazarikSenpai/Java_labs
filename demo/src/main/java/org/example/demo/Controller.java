package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {

    public ImageView imageView;
    public Button photoButton;
    public TableView table;
    @FXML
    private AnchorPane ScrollPaneAnchor;

    @FXML
    private AnchorPane controlsPane;

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
    private Label latitudeLabel;

    @FXML
    private TextField latitudeTextField;

    @FXML
    private TableColumn<?, ?> longitudeColumn;

    @FXML
    private Label longitudeLabel;

    @FXML
    private TextField longitudeTextField;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;

    @FXML
    private TableColumn<?, ?> photoColumn;

    @FXML
    private Label photoLabel;

    @FXML
    private TableColumn<?, ?> regionColumn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane tablePane;

    @FXML
    private Button updateButton;

}
