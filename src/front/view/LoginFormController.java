package front.view;

import back.entities.Users;
import back.utility.Connector;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;

/**
 * LoginFormController Controller class
 *
 * @author Hassan
 */
public class LoginFormController implements Initializable {

    EntityManager mainEm;
    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Label errorMessage;

    private MainApp mainApp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainEm = Connector.getMainEntityManager();
        System.out.println("in LoginFormController initialize method");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                userName.requestFocus();
            }
        });
    }

    @FXML
    private void processLogin(ActionEvent event) {
        System.out.println("LoginLoginLoginLoginLoginLoginLoginLogin");

        String name = userName.getText();
        String pass = password.getText();
        List<Users> listOfUsers = mainEm.createNamedQuery("Users.findAll").getResultList();
        for (Users user : listOfUsers) {
            System.out.println(user.getUserName());
            if (userName.getText().equals(user.getUserName()) && password.getText().equals(user.getUserPassword()) && user.getUserStatus() == true) {
                System.out.println("مبروووووووووووووووووووووووووك");
                ((Node) (event.getSource())).getScene().getWindow().hide();

            } else {
                errorMessage.setText("اسم المستخدم او كلمة المرور غير صحيح");
                System.out.println("خووووووووووووووووووودخووووووووووووووووووودخووووووووووووووووووودخووووووووووووووووووود");
            }

        }
        Connector.getDataEntityManager();

    }

    @FXML
    private void processExit(ActionEvent event) {
        System.out.println("exitexitexitexitexitexitexit");
        Connector.closeConnections();
        System.exit(0);

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
