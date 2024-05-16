package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.*;

public class Controller {
    public Button connectButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn<Model, Integer> idColumn;
    @FXML
    private Label idLabel;
    @FXML
    private TextField idTextField;
    @FXML
    private ImageView imageView;
    @FXML
    private Button insertButton;
    @FXML
    private TableColumn<Model, Double> latColumn;
    @FXML
    private Label latLabel;
    @FXML
    private TextField latTextField;
    @FXML
    private TableColumn<Model, Double> longColumn;
    @FXML
    private Label longLabel;
    @FXML
    private TextField longTextField;
    @FXML
    private TableColumn<Model, String> nameColumn;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private Button photoButton;
    @FXML
    private TableColumn<Model, String> photoColumn;
    @FXML
    private Label photoLabel;
    @FXML
    private Label photoPathLabel;
    @FXML
    private Button printButton;
    @FXML
    private TableColumn<Model, String> regionColumn;
    @FXML
    private ComboBox<String> regionComboBox;
    @FXML
    private Label regionLabel;
    @FXML
    private TableView<Model> tableView;
    @FXML
    private Button updateButton;

    private String selectedPhotoPath;
    private Connection connection = DatabaseConnection.getConnection();

    public ObservableList<Model> getLandmarks() {
        ObservableList<Model> data = FXCollections.observableArrayList();
        String query = "SELECT id, name, latitude, longitude, region, photo FROM landmarks";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                String region = resultSet.getString("region");
                byte[] photo = resultSet.getBytes("photo");
                data.add(new Model(id, name, latitude, longitude, region, photo));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    private final ObservableList<String> regions = FXCollections.observableArrayList(
            "Вінницька область", "Волинська область", "Дніпропетровська область", "Донецька область",
            "Житомирська область", "Закарпатська область", "Запорізька область", "Івано-Франківська область",
            "Київська область", "Кіровоградська область", "Луганська область", "Львівська область",
            "Миколаївська область", "Одеська область", "Полтавська область", "Рівненська область",
            "Сумська область", "Тернопільська область", "Харківська область", "Херсонська область",
            "Хмельницька область", "Черкаська область", "Чернівецька область", "Чернігівська область",
            "Київ", "Севастополь"
    );

    public void getTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        latColumn.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longColumn.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        photoColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));

        ObservableList<Model> data = this.getLandmarks();
        tableView.setItems(data);

        regionComboBox.setItems(regions);
    }

    @FXML
    private void photoButtonOnClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            selectedPhotoPath = selectedFile.getAbsolutePath();
            photoPathLabel.setText(selectedPhotoPath);
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    @FXML
    public void printButtonOnClicked() {
        Model selectedLandmark = tableView.getSelectionModel().getSelectedItem();
        if (selectedLandmark != null) {
            idTextField.setText(String.valueOf(selectedLandmark.getId()));
            nameTextField.setText(selectedLandmark.getName());
            latTextField.setText(String.valueOf(selectedLandmark.getLatitude()));
            longTextField.setText(String.valueOf(selectedLandmark.getLongitude()));
            regionComboBox.setValue(selectedLandmark.getRegion());
            photoPathLabel.setText("file path");

            byte[] photoBytes = selectedLandmark.getPhoto();
            if (photoBytes != null) {
                Image image = new Image(new ByteArrayInputStream(photoBytes));
                imageView.setImage(image);
            } else {
                imageView.setImage(null);
            }
        }
    }

    @FXML
    public void clearButtonOnClicked(){
        idTextField.setText("");
        nameTextField.setText("");
        latTextField.setText("");
        longTextField.setText("");
        regionComboBox.setValue("");
        photoPathLabel.setText("file path");
        imageView.setImage(null);
    }

    @FXML
    private void insertButtonOnClicked() {
        String name = nameTextField.getText();
        double latitude = Double.parseDouble(latTextField.getText());
        double longitude = Double.parseDouble(longTextField.getText());
        String region = regionComboBox.getValue();

        String sql = "INSERT INTO landmarks (name, latitude, longitude, region, photo) VALUES (?, ?, ?, ?, LOAD_FILE(?))";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, latitude);
            pstmt.setDouble(3, longitude);
            pstmt.setString(4, region);
            pstmt.setString(5, selectedPhotoPath);

            pstmt.executeUpdate();

            tableView.setItems(this.getLandmarks());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteButtonOnClicked() {
        int id = Integer.parseInt(idTextField.getText());

        String sql = "DELETE FROM landmarks WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            tableView.setItems(this.getLandmarks());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
