package front.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hassa_000
 */
public class NewAccountingNoteBookController implements Initializable, ControlledScreen {

    @FXML
    private TextField AccountingNoteBookName;

    @FXML
    private PasswordField AccountingNoteBookPassword;

    @FXML
    private Button okButton;

    AccountingFilesFormController accountingFilesFormController;

    MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        okButton.setDisable(true);
        AccountingNoteBookName.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty());
        });
    }

    @FXML
    public void processNewAccountingNoteBook() {
        String accNoteBookName = AccountingNoteBookName.getText();
        String accNoteBookPass = AccountingNoteBookPassword.getText();
        accountingFilesFormController.processAddAcoountingNoteBook(accNoteBookName, accNoteBookPass);

    }

    @FXML
    public void cancel() {
        accountingFilesFormController.accNoteBook.hide();
    }

    void setAccountingFilesForm(AccountingFilesFormController aThis) {
        this.accountingFilesFormController = aThis;
    }

    @Override
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
