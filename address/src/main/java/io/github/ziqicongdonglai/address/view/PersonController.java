package io.github.ziqicongdonglai.address.view;


import io.github.ziqicongdonglai.address.MainApp;
import io.github.ziqicongdonglai.address.model.Person;
import io.github.ziqicongdonglai.address.util.DateUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersonController {
    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, String> clazzColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private Label clazzLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private ImageView avatar;

    private MainApp mainApp;

    public PersonController() {

    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        clazzColumn.setCellValueFactory(cellData -> cellData.getValue().clazzProperty());
        showPersonDetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        ObservableList<Person> personDate = mainApp.getPersonDate();
        personTable.setItems(personDate);
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            nameLabel.setText(person.getName());
            clazzLabel.setText(person.getClazz());
            genderLabel.setText(person.getGender());
            addressLabel.setText(person.getAddress());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            avatar.setImage(person.getAvatar());
        } else {
            nameLabel.setText("");
            clazzLabel.setText("");
            genderLabel.setText("");
            addressLabel.setText("");
            birthdayLabel.setText("");
            avatar.setImage(new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/avatar.jpg"));
        }
    }
}