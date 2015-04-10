package front.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Hassan
 */
public class DailyFormController implements Initializable , ControlledScreen {

    MainApp mainApp;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp ;
    }
    
}
