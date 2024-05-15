package group.ukrainelandmarks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class HelloController {
    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private ImageView imageView;

    @FXML
    private Label latLabel;

    @FXML
    private TextField latTextField;

    @FXML
    private Label longLabel;

    @FXML
    private TextField longTextField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button photoButton;

    @FXML
    private Label photoLabel;

    @FXML
    private Label photoPathLabel;

    @FXML
    private ComboBox<?> regionComboBox;

    @FXML
    private Label regionLabel;
}