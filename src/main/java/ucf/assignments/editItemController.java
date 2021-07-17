package ucf.assignments;
import javafx.beans.Observable;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.DatePicker;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class editItemController implements Initializable {
    @FXML
    private Button clearList;
    @FXML
    private TextField itemName;
    @FXML
    private TextField description;
    @FXML
    private DatePicker date;
    @FXML
    private Label selectDate;
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
        Tableview.setEditable(true);
        itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        Tableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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

    public void addButton(ActionEvent event){
        try {
            ObservableList<item> item = Tableview.getItems();
            item newItem = new item(itemName.getText(), description.getText(), date.getValue(), status);
            CheckBox check = new CheckBox();
            String checkDescription = description.getText();
            int descriptionLength = checkDescription.length();
            if(descriptionLength > 1 || descriptionLength < 256) {
                Tableview.getItems().add(newItem);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //gets items from observable list
    public ObservableList<item> getItems(){
        ObservableList<item> item = FXCollections.observableArrayList();
        return item;
    }
    //clear the list using .clear
    public void clearList(){
        Tableview.getItems().clear();
    }
    //Method to removeItems from List by selecting the items and storing into a temporary array
    //then removing them with for each loop
    public void removeItem() {
        ObservableList<item> itemSelected = Tableview.getSelectionModel().getSelectedItems();
        ObservableList<item> tempItemArray = Tableview.getItems();
        for(item item : itemSelected){
            tempItemArray.remove(item);
        }
    }
    //edits items from TableView
    public void editItem(TableColumn.CellEditEvent editEvent){
        item itemToBeEdited = Tableview.getSelectionModel().getSelectedItem();
        itemToBeEdited.setItem(editEvent.getNewValue().toString());
    }
    //edits Description from Table View
    public void editDescription(TableColumn.CellEditEvent editEvent) {
        item descriptionToBeEdited = Tableview.getSelectionModel().getSelectedItem();
        descriptionToBeEdited.setDescription(editEvent.getNewValue().toString());
    }

    public void editDate(TableColumn.CellEditEvent editEvent) {
        item dateToBeEdited = Tableview.getSelectionModel().getSelectedItem();
    }
}
