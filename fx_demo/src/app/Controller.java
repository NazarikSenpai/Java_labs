package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public Button resultButton;
    public Label resultLabel;
    public Button clearButton;
    public TextField firstLatitude;
    public TextField firstLongitude;
    public TextField secondLatitude;
    public TextField secondLongitude;

    @FXML


    public void clearOnClick(){
        System.out.println("clicked");
        firstLatitude.setText("");
        firstLongitude.setText("");
        secondLatitude.setText("");
        secondLongitude.setText("");
    }
}
