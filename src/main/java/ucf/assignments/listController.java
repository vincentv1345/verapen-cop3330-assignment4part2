package ucf.assignments;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
public class listController {
    @FXML
    private ListView<String> listTitles;

    @FXML
    private TextField listTitle;

    @FXML
    private Button addList;

    @FXML
    private Button removeList;

    @FXML
    private Button editList;

    @FXML void removeList(MouseEvent event){
        int itemID = listTitles.getSelectionModel().getSelectedIndex();
        listTitles.getItems().remove(itemID);
    }
    @FXML
    public void addList(MouseEvent mouseEvent) {
        listTitles.getItems().add(listTitle.getText());
    }
    @FXML
    public void editList(MouseEvent mouseEvent){

    }
    @FXML
    /*
    * changes scene when used
     */
    public void changeScene(ActionEvent event) throws IOException {
        Parent itemParent = FXMLLoader.load(getClass().getResource("editItemController.fxml"));
        Scene editItemScene = new Scene(itemParent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(editItemScene);
        stage.show();
    }
}
