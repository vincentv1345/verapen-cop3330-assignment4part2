package ucf.assignments;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
public class editItemController implements Initializable {
    @FXML
    private Button addDate;
    @FXML
    private Button addItem;
    @FXML
    private Button addDescription;
    @FXML
    private Button removeItem;
    @FXML
    private Button editDescription;
    @FXML
    private Button editDate;
    @FXML
    private TextField item;
    @FXML
    private TextField description;
    @FXML
    private TextField date;
    @FXML
    private ListView<String> itemList;
    @FXML
    private ListView<String> dateList;
    @FXML
    private ListView<String> descriptionList;
    @FXML
    private TableView<item> Tableview;
    @FXML
    private TableColumn<item, String> itemColumn;
    @FXML
    private TableColumn<item, String> descriptionColumn;
    @FXML
    private TableColumn<item, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<item, CheckBox> completionStatusColumn;
    @FXML
    private CheckBox getCompletionStatus;
    @FXML
    private CheckBox status;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemColumn.setCellValueFactory(new PropertyValueFactory<item, String>("item"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<item, String>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<item, LocalDate>("dueDate"));
        completionStatusColumn.setCellValueFactory(new PropertyValueFactory<item, CheckBox>("completionStatus"));

        Tableview.setItems(getItems());
    }
    public void changeScene(ActionEvent event) throws IOException {
        Parent itemParent = FXMLLoader.load(getClass().getResource("todoListsController.fxml"));
        Scene editItemScene = new Scene(itemParent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(editItemScene);
        stage.show();
    }
    public void getCompletionStatus(){

    }
    public ObservableList<item> getItems(){
        ObservableList<item> item = FXCollections.observableArrayList();
            item.add(new item("person", "sgsdf", LocalDate.of(2007, Month.NOVEMBER, 13), status));
            CheckBox check = new CheckBox();
        return item;
    }

    public void addDate(ActionEvent event) {
        itemList.getItems().add(item.getText());
    }

    public void addDescription(ActionEvent event) {
        descriptionList.getItems().add(description.getText());
    }

    public ListView<String> addItem(ActionEvent event) {
        itemList.getItems().add(item.getText());
        return itemList;
    }

    public void removeItem(MouseEvent mouseEvent) {
        int itemID = itemList.getSelectionModel().getSelectedIndex();
        itemList.getItems().remove(itemID);
    }

    public void editDescription(MouseEvent mouseEvent) {
        itemList.setEditable(true);
        itemList.setCellFactory(TextFieldListCell.forListView());
    }

    public void editDate(MouseEvent mouseEvent) {
        dateList.setEditable(true);
        dateList.setCellFactory(TextFieldListCell.forListView());
    }
}
