package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    public Button resultButton, clearButton;
    public Label resultLabel;
    public TextField firstLatitude, firstLongitude, secondLatitude, secondLongitude;
    public RadioButton degreeRadio, radianRadio;
    public ToggleGroup radioGroup;

    @FXML

    public void resultOnClick(){
        double firstLat = Double.parseDouble(firstLatitude.getText());
        double firstLong = Double.parseDouble(firstLongitude.getText());
        double secondLat = Double.parseDouble(secondLatitude.getText());
        double secondLong = Double.parseDouble(secondLongitude.getText());
        if (degreeRadio.isSelected()){
            System.out.println("selected");
            firstLat = Math.toRadians(firstLat);
            firstLong = Math.toRadians(firstLong);
            secondLat = Math.toRadians(secondLat);
            secondLong = Math.toRadians(secondLong);
        }

        double distance = Math.round(Model.calculateDistance(firstLat,firstLong,secondLat,secondLong));

        resultLabel.setText(distance + "кілометрівметрів");
    }

    public void clearOnClick(){
        System.out.println("clicked");
        firstLatitude.setText("");
        firstLongitude.setText("");
        secondLatitude.setText("");
        secondLongitude.setText("");
    }
}
