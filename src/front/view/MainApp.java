package front.view;

import back.utility.Connector;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Hassan
 */
public class MainApp extends Application {

    public Stage primaryStage;
    private BorderPane mainForm;
    public Stage accountingFilesStage;
    MainFormController mainController;

    public MainApp() {
    }

    @Override
    public void init() throws Exception {
        System.out.println("in init");
    }
    // CREATE ROOT

    @Override
    public void start(Stage primaryStage) {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("البسيط للتجارة والكمسيون");
        File f = new File("Main Hal.data");
        File f2 = new File("Main Hal.properties");
        File f3 = new File("Main Hal.script");
        if (f.exists() == false || f2.exists() == false || f3.exists() == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ في ملف قاعدة البيانات");
            alert.setHeaderText("يبدو أن ملف قاعدة البيانات الرئيسي غير موجود");
            alert.setContentText("الرجاء التحقق من الملفات وشكرا");
            alert.showAndWait();

        } else {

            initMainForm();
            showLogInForm();
        }
    }

    private void initMainForm() {

        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MainForm.fxml"));
            mainForm = (BorderPane) loader.load();
            Scene scene = new Scene(mainForm);
            primaryStage.setScene(scene);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setWidth(primScreenBounds.getWidth());
            primaryStage.setHeight(primScreenBounds.getHeight());
            System.out.println("width" + primaryStage.getWidth() + "hieght" + primaryStage.getHeight());
            primaryStage.setMaximized(true);

            // Give the controller access to the main app.
            mainController = loader.getController();
            mainController.setMainApp(this);
            primaryStage.show();
            primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent arg0) {
                    System.out.println("OnCloseRequest OnCloseRequest OnCloseRequest OnCloseRequest");
                    Connector.closeConnections();
                    System.exit(0);

                }
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogInForm() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("LoginForm.fxml"));
            AnchorPane loginForm = (AnchorPane) loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("تسجيل الدخول");
            loginStage.initModality(Modality.WINDOW_MODAL);
            loginStage.initOwner(primaryStage);
            //  loginStage.centerOnScreen();
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            System.out.println(Screen.getPrimary().getBounds());

            loginStage.setResizable(false);
            System.out.println(loginStage.getWidth());
            // loginStage.setX(100);
            //loginStage.setY(100);

            Scene scene = new Scene(loginForm, 400, 500);
            loginStage.setScene(scene);
            loginStage.centerOnScreen();
            //loginStage.setX((primScreenBounds.getWidth() - 400) / 2);
            //loginStage.setY((primScreenBounds.getHeight() - 500) / 4);
            //System.out.println("x isssss"+(primScreenBounds.getWidth() - 400) / 2);
            // Set person overview into the center of root layout.

            // Give the controller access to the main app.
            LoginFormController controller = loader.getController();
            controller.setMainApp(this);
            loginStage.showAndWait();
            System.out.println("x isss" + loginStage.getX() + "y isss" + loginStage.getY());

            System.out.println((primScreenBounds.getWidth() - loginStage.getWidth()) / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAccountingFilesForm() {
        Boolean condition = true;
        for (Tab t : mainController.mainTab.getTabs()) {
            if (t.getText().equals("خدمة الملفات")) {
                condition = false;
                mainController.mainTab.getSelectionModel().select(t);
            }
        }
        if (condition == true) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AccountingFilesForm.fxml"));
            BorderPane AccountingFilesForm = new BorderPane();
            try {
                AccountingFilesForm = (BorderPane) loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            AccountingFilesFormController controller = loader.getController();
            controller.setMainApp(this);
            Tab accountingTab = new Tab("خدمة الملفات");
            accountingTab.setContent(AccountingFilesForm);
            mainController.mainTab.getTabs().add(accountingTab);
            mainController.mainTab.getSelectionModel().select(accountingTab);
        }

        /*accountingFilesStage = new Stage();
         accountingFilesStage.setTitle("خدمة الملفات");
         accountingFilesStage.initModality(Modality.WINDOW_MODAL);*/
            //accountingFilesStage.initOwner(primaryStage);
        // loginStage.centerOnScreen();
        // Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        //System.out.println(Screen.getPrimary().getBounds());

        /*accountingFilesStage.setMaximized(true);
         accountingFilesStage.initOwner(primaryStage);*/
        //  System.out.println(loginStage.getWidth());
        // loginStage.setX(100);
        //loginStage.setY(100);
        //Scene scene = new Scene(AccountingFilesForm);
        //accountingFilesStage.setScene(scene);
        //primaryStage.centerOnScreen();
        //loginStage.setX((primScreenBounds.getWidth() - 400) / 2);
        //loginStage.setY((primScreenBounds.getHeight() - 500) / 4);
        //System.out.println("x isssss"+(primScreenBounds.getWidth() - 400) / 2);
        // Set person overview into the center of root layout.
        // Give the controller access to the main app.
        //accountingFilesStage.show();
        //mainForm.setRight(AccountingFilesForm);
        //  System.out.println ("x isss"+loginStage.getX() + "y isss" + loginStage.getY());
        //    System.out.println((primScreenBounds.getWidth() - loginStage.getWidth()) / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void hideLoginForm() {
        // loginStage.hide();
        // showAccountingFilesForm();
    }

    void showDailyForm() {

        Boolean condition = true;
        for (Tab t : mainController.mainTab.getTabs()) {
            if (t.getText().equals("دفتر اليومية")) {
                condition = false;
                mainController.mainTab.getSelectionModel().select(t);
            }
        }

        if (condition == true) {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane dailyPane = null;
            loader.setLocation(MainApp.class.getResource("DailyForm.fxml"));
            try {
                dailyPane = (AnchorPane) loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }

            Tab dailyTab = new Tab("دفتر اليومية");
            dailyTab.setContent(dailyPane);
            mainController.mainTab.getTabs().add(dailyTab);
            mainController.mainTab.getSelectionModel().select(dailyTab);
        }


        /*
         mainForm.getChildren().add(dailyPane);
         Scene scene = new Scene(mainForm);
         primaryStage.setScene(scene);
         primaryStage.setMaximized(true);*/
    }
}
