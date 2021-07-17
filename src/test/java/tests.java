import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class tests {
    private List<String> itemLists;
    private String item;
    public boolean checkWidth(List<String> lists) {
        boolean width = false;
        for(int i = 0; i < lists.size(); i++) {
            String element = lists.get(i);
            int num = element.length();
            if(num <256){
                width = true;
                break;
            }
            else{
                i++;
            }
        }
        return width;
    }
    @Test
    public void arrayCheck(){
    }
}
