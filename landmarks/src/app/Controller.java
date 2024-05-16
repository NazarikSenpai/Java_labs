package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private TableColumn<Model, byte[]> photoColumn;
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
    public ObservableList<Model> getLandmarks() {
        ObservableList<Model> data = FXCollections.observableArrayList();
        String query = "SELECT id, name, latitude, longitude, region, photo FROM landmarks";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
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
    }
}
