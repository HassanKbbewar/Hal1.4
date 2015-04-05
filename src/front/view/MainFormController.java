/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view;

import back.utility.Connector;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Hassa_000
 */
public class MainFormController implements Initializable {

    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("in MainFormController initialize method");
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void showAccountingFilesForm(ActionEvent event) {
        mainApp.showAccountingFilesForm();

    }

    @FXML
    private void handleExit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(mainApp.primaryStage);
        alert.setTitle("تأكيد الخروج");
        alert.setHeaderText("هل أنت متأكد من إنهاء العمل والخروج ؟");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Connector.closeConnections();
            System.exit(0);
        } else {
    // ... user chose CANCEL or closed the dialog
        }

    }

}