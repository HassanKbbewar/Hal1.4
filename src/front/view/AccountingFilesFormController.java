package front.view;

import back.entities.AccountingFiles;
import back.entities.AccountingFilesDetails;
import back.utility.Connector;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Hassan
 */
public class AccountingFilesFormController implements Initializable {

    @FXML
    private TableView<AccountingFiles> AccountingFilesTable;

    @FXML
    private TableView<AccountingFilesDetails> AccountingFilesDetailsTable;

    @FXML
    private TableColumn<AccountingFilesDetails, Boolean> accountingFilesDetailsSelectedFile;

    @FXML
    private TableColumn<AccountingFilesDetails, LocalDate> accountingFilesDetailsStartDate;

    @FXML
    private TableColumn<AccountingFilesDetails, LocalDate> accountingFilesDetailsEndDate;

    @FXML
    private TableColumn<AccountingFilesDetails, String> accountingFilesDetailsFileName;

    @FXML
    private TableColumn<AccountingFilesDetails, String> accountingFilesDetailsLocation;

    @FXML
    private TableColumn<AccountingFilesDetails, String> accountingFilesDetailsBackupLocation;

    @FXML
    private TableColumn<AccountingFilesDetails, Boolean> accountingFilesDetailsClosed;

    @FXML
    private TableColumn<AccountingFiles, Boolean> currentAccountingSelectedFile;

    @FXML
    private TableColumn<AccountingFiles, String> accountingFileName;

    @FXML
    private TableColumn<AccountingFiles, String> accountingFilePassword;

    private ObservableList<AccountingFiles> accountingData = FXCollections.<AccountingFiles>observableArrayList();
    private ObservableList<AccountingFilesDetails> accountingDetails = FXCollections.<AccountingFilesDetails>observableArrayList();

    EntityManager mainEm = Connector.getMainEntityManager();

    MainApp mainApp;

    public Stage accNoteBook;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        System.out.println(AccountingFilesTable);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initElements();

    }

    public void initElements() {
        accountingFileName.setCellValueFactory(new PropertyValueFactory<AccountingFiles, String>("accFileName"));
        accountingFileName.setCellFactory(TextFieldTableCell.<AccountingFiles>forTableColumn());
        accountingFilePassword.setCellValueFactory(new PropertyValueFactory<AccountingFiles, String>("accFilePassword"));
        accountingFilePassword.setCellFactory(param -> new PasswordLabelCell());
        currentAccountingSelectedFile.setCellValueFactory(new PropertyValueFactory<AccountingFiles, Boolean>("currentAccSelectedFile"));
        currentAccountingSelectedFile.setCellFactory(CheckBoxTableCell.forTableColumn(currentAccountingSelectedFile));
        currentAccountingSelectedFile.setEditable(false);
        AccountingFilesTable.setEditable(true);
        addingItems();
        accountingFilesDetailsSelectedFile.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, Boolean>("currentAccSelectedFile"));
        accountingFilesDetailsSelectedFile.setCellFactory(CheckBoxTableCell.forTableColumn(accountingFilesDetailsSelectedFile));
        accountingFilesDetailsStartDate.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, LocalDate>("accFilesDetailsStartDate"));
        DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        accountingFilesDetailsStartDate.setCellFactory(column -> {
            return new TableCell<AccountingFilesDetails, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        setText(myDateFormatter.format(item));

                        // Style all dates in March with a different color.
                    }
                }
            };
        });

        accountingFilesDetailsEndDate.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, LocalDate>("accFilesDetailsEndDate"));
        accountingFilesDetailsEndDate.setCellFactory(column -> {
            return new TableCell<AccountingFilesDetails, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        setText(myDateFormatter.format(item));

                        // Style all dates in March with a different color.
                    }
                }
            };
        });
        accountingFilesDetailsFileName.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, String>("accountingFilesDetailsFileName"));
        accountingFilesDetailsFileName.setCellFactory(TextFieldTableCell.<AccountingFilesDetails>forTableColumn());

        accountingFilesDetailsLocation.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, String>("accountingFilesDetailsFileLocation"));
        accountingFilesDetailsLocation.setCellFactory(TextFieldTableCell.<AccountingFilesDetails>forTableColumn());

        accountingFilesDetailsBackupLocation.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, String>("accountingFilesDetailsFileBackup"));
        accountingFilesDetailsBackupLocation.setCellFactory(TextFieldTableCell.<AccountingFilesDetails>forTableColumn());

        accountingFilesDetailsClosed.setCellValueFactory(new PropertyValueFactory<AccountingFilesDetails, Boolean>("accClosedFile"));
        accountingFilesDetailsClosed.setCellFactory(CheckBoxTableCell.forTableColumn(accountingFilesDetailsClosed));

        AccountingFilesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAccountingFilesDetails(newValue));
    }

    public void addingItems() {
        List<AccountingFiles> listOfAccountingFiles = mainEm.createNamedQuery("AccountingFiles.findAll").getResultList();
        accountingData.setAll(listOfAccountingFiles);
        AccountingFilesTable.setItems(accountingData);
        for (AccountingFiles af : accountingData) {
            if (af.getAccountingFilesActiveStatus() == true) {
                AccountingFilesTable.getSelectionModel().clearAndSelect(accountingData.indexOf(af));
                List<AccountingFilesDetails> listOfAccDetails = af.getAccountingFilesDetailsList();
                accountingDetails.setAll(listOfAccDetails);
                AccountingFilesDetailsTable.setItems(accountingDetails);
            }
        }

    }

    @FXML
    private void handleSelect(AccountingFiles curraccfile) {
        System.out.println("begin handleSelect");

        //AccountingFilesTable.getSelectionModel().clearSelection();
        System.out.println("after clearSelection");
        //AccountingFilesTable.getSelectionModel().select(null);
        System.out.println(curraccfile.getAccountingFilesName());

        for (AccountingFiles af : accountingData) {

            mainEm.getTransaction().begin();
            af.setAccountingFilesActiveStatus(false);
            mainEm.getTransaction().commit();
            //accountingData.set(accountingData.indexOf(af), af);
            System.out.println("in looooooooooooop");
        }
        System.out.println("after the loop finished");
        mainEm.getTransaction().begin();
        curraccfile.setAccountingFilesActiveStatus(true);
        mainEm.getTransaction().commit();
        System.out.println("after the lastcommit of  finished");
        List<AccountingFiles> listOfAccountingFiles = mainEm.createNamedQuery("AccountingFiles.findAll").getResultList();
        //AccountingFilesTable.getSelectionModel().clearSelection();

        /*AccountingFilesTable.requestFocus();
         AccountingFilesTable.getSelectionModel().select(-1);*/
        accountingData.setAll(listOfAccountingFiles);
        System.out.println("after setall method");
        List<AccountingFilesDetails> listOfAccDetails = curraccfile.getAccountingFilesDetailsList();
        accountingDetails.setAll(listOfAccDetails);
        AccountingFilesDetailsTable.setItems(accountingDetails);
    }

    public void showNewAccountingNoteBookDialog() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AccountingFilesFormController.class.getResource("NewAccountingNoteBook.fxml"));
            GridPane newAccountingNoteBookDialog = (GridPane) loader.load();
            accNoteBook = new Stage();
            accNoteBook.setTitle("إنشاء ملف محاسبي جديد");
            accNoteBook.initModality(Modality.WINDOW_MODAL);
            accNoteBook.initOwner(mainApp.accountingFilesStage);
            accNoteBook.centerOnScreen();
            accNoteBook.setResizable(false);
            Scene scene = new Scene(newAccountingNoteBookDialog);
            accNoteBook.setScene(scene);
            NewAccountingNoteBookController controller = loader.getController();
            controller.setAccountingFilesForm(this);
            accNoteBook.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processAddAcoountingNoteBook(String AccountingNoteBookName, String AccountingNoteBookPassword) {
        accNoteBook.hide();
        AccountingFiles newAccAccountingFiles = new AccountingFiles();
        if (!AccountingNoteBookName.equals("")) {
            newAccAccountingFiles.setAccountingFilesName(AccountingNoteBookName);
            newAccAccountingFiles.setAccountingFilesActiveStatus(Boolean.FALSE);
            if (!AccountingNoteBookPassword.equals("")) {
                newAccAccountingFiles.setAccountingFilesPassword(AccountingNoteBookPassword);
            } else {
                newAccAccountingFiles.setAccountingFilesPassword("");
            }
        }
        Connector.getMainEntityManager().getTransaction().begin();
        Connector.getMainEntityManager().persist(newAccAccountingFiles);
        Connector.getMainEntityManager().getTransaction().commit();
        addingItems();

    }

    @FXML
    private void addAcoountingNoteBook() {

        showNewAccountingNoteBookDialog();
    }

    @FXML
    private void removeAcoountingNoteBook() {

        AccountingFiles currAccFile = AccountingFilesTable.getSelectionModel().getSelectedItem();
        if (currAccFile != null && currAccFile.getAccountingFilesPassword().equals("")) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("تأكيد حذف الدفتر المحاسبي");
            alert.setHeaderText("تحذير");
            alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);

            alert.setContentText("هل أنت متأكد من حذف الدفتر المحاسبي " + currAccFile.getAccountingFilesName());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Connector.getMainEntityManager().getTransaction().begin();
                Connector.getMainEntityManager().remove(currAccFile);
                Connector.getMainEntityManager().getTransaction().commit();
                addingItems();
            } else {
                alert.hide();
            }

        } else {
            if (currAccFile != null && !currAccFile.getAccountingFilesPassword().equals("")) {
                if (showAccountingBookPasswordConfirm(currAccFile) == true) {
                    Connector.getMainEntityManager().getTransaction().begin();
                    Connector.getMainEntityManager().remove(currAccFile);
                    Connector.getMainEntityManager().getTransaction().commit();
                    addingItems();
                }
            }
        }

    }

    public void showChangePasswordDialog(AccountingFiles accFile) {
        Dialog<String> dialog;
        dialog = new Dialog<>();
        dialog.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
        dialog.setTitle("تغيير كلمة المرور");
        dialog.setHeaderText("تغيير كلمة المرور الخاصة بالدفتر المحاسبي");
        ButtonType okButton = new ButtonType("تغيير", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("إلغاء", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                password.requestFocus();
            }
        });
        grid.add(new Label(" الرجاء إذخال كلمة المرور الجديدة"), 0, 0);
        grid.add(password, 1, 0);
        Node ok = dialog.getDialogPane().lookupButton(okButton);
        ok.setDisable(true);
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            ok.setDisable(newValue.trim().isEmpty());
        });
        //Platform.runLater(password.requestFocus());
        password.requestFocus();
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButton) {
                return new String(password.getText());
            }
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        if (result != null && result.isPresent()) {

            Connector.getMainEntityManager().getTransaction().begin();
            accFile.setAccountingFilesPassword(result.get());
            Connector.getMainEntityManager().merge(accFile);
            Connector.getMainEntityManager().getTransaction().commit();
            addingItems();

        }
    }

    public Boolean showAccountingBookPasswordConfirm(AccountingFiles accFile) {
        Dialog<String> dialog;
        dialog = new Dialog<>();
        dialog.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
        dialog.setTitle("هذا الدفتر يحتوي على كلمة مرور مسبقا");
        dialog.setHeaderText("تأكيد كلمة المرور");
        ButtonType okButton = new ButtonType("موافق", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("إلغاء", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        PasswordField password = new PasswordField();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                password.requestFocus();
            }
        });
        password.setPromptText("Password");
        grid.add(new Label("الرجاء إذخال كلمة المرور"), 0, 0);
        grid.add(password, 1, 0);
        Node ok = dialog.getDialogPane().lookupButton(okButton);
        ok.setDisable(true);
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            ok.setDisable(newValue.trim().isEmpty());
        });
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButton) {
                return new String(password.getText());
            }
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        if (result != null && result.isPresent()) {
            if (result.get().equals(accFile.getAccountingFilesPassword())) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
                alert.setTitle("خطأ في كلمة المرور");
                alert.setContentText("كلمة المرور التي أدخلتها غير صحيحة");
                alert.showAndWait();
                return false;
            }
        }
        return false;
    }

    @FXML
    private void changeAcoountingNoteBookPassword() {
        AccountingFiles currAccFile = AccountingFilesTable.getSelectionModel().getSelectedItem();
        if (currAccFile != null && currAccFile.getAccountingFilesPassword().equals("")) {
            showChangePasswordDialog(currAccFile);
        } else if (currAccFile != null && !currAccFile.getAccountingFilesPassword().equals("")) {
            if (showAccountingBookPasswordConfirm(currAccFile) == true) {
                showChangePasswordDialog(currAccFile);
            }

        }

    }

    private void openingCycleShowDialog() {
        int year = LocalDate.now().getYear();
        TextInputDialog dialog = new TextInputDialog();
        dialog.getEditor().setText(null);
        dialog.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        dialog.initOwner(mainApp.accountingFilesStage);
        dialog.setTitle("الرجاء تحديد إسم للدورة الجديدة");
        dialog.setContentText("الرجاء قم بإدخال إسم الدورة :");
        Node loginButton = dialog.getDialogPane().lookupButton(ButtonType.OK);
        loginButton.setDisable(true);
        dialog.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });
        dialog.getEditor().setText("" + year);
        Optional<String> result = dialog.showAndWait();
        openingCycleCheck(result);
    }

    @FXML
    private void addOpeningCycle() {
        AccountingFiles selectedAccFile = AccountingFilesTable.getSelectionModel().getSelectedItem();
        if (selectedAccFile == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
            alert.setTitle("لا يوجد دفتر محاسبي محدد");
            alert.setContentText("الرجاء إختيار دفتر محاسبي للمتابعة");
            alert.showAndWait();
        }

        if (selectedAccFile != null && selectedAccFile.getAccountingFilesDetailsList().isEmpty() == true) {
            System.out.println("currAccFile != null && currAccFile.getAccountingFilesDetailsList() == null");
            if (selectedAccFile.getAccountingFilesPassword().equals("")) {
                System.out.println("currAccFile != null && currAccFile.getAccountingFilesDetailsList() == null currAccFile.getAccountingFilesPassword().equals(\"\")");
                openingCycleShowDialog();
            } else if (!selectedAccFile.getAccountingFilesPassword().equals("")) {
                if (showAccountingBookPasswordConfirm(selectedAccFile) == true) {
                    openingCycleShowDialog();
                }
            }
        } else if (selectedAccFile != null && selectedAccFile.getAccountingFilesDetailsList().isEmpty() == false) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("يوجد دورة مسبقا لهذا الدفتر المحاسبي");
            alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
            alert.setContentText("غير ممكن إنشاء دورة افتتاحية لأنه يوجد دورة مسبقا");
            alert.showAndWait();
        }
    }

    private void openingCycleCheck(Optional<String> newResult) {
        if (newResult.isPresent()) {

            File source = new File("New Data.data");
            File source2 = new File("New Data.properties");
            File source3 = new File("New Data.script");
            File dest = new File(newResult.get() + ".data");
            File dest2 = new File(newResult.get() + ".properties");
            File dest3 = new File(newResult.get() + ".script");

            if (dest.exists() == false && dest2.exists() == false && dest3.exists() == false) {
                System.out.println("dest.exists() == falsedest.exists() == false");
                try {
                    copyOpeningCycleFiles(source, dest, source2, dest2, source3, dest3);
                } catch (IOException ex) {
                    Logger.getLogger(AccountingFilesFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
                AccountingFilesDetails newDetail = new AccountingFilesDetails();
                newDetail.setAccountingId(AccountingFilesTable.getSelectionModel().getSelectedItem());
                newDetail.setActiveStatus(false);
                newDetail.setCycleStartDate(new Date());
                newDetail.setFileBackupName(newResult.get() + "_Backup");
                newDetail.setFileCosedFlag(false);
                newDetail.setFileName(newResult.get());
                newDetail.setFilePath(dest.getAbsoluteFile().getParent());
                mainEm.getTransaction().begin();
                mainEm.persist(newDetail);
                if (AccountingFilesTable.getSelectionModel().getSelectedItem().getAccountingFilesDetailsList() != null) {
                    AccountingFilesTable.getSelectionModel().getSelectedItem().getAccountingFilesDetailsList().add(newDetail);
                } else {
                    List<AccountingFilesDetails> listOfAccDetails = new ArrayList<AccountingFilesDetails>();
                    listOfAccDetails.add(newDetail);
                    AccountingFilesTable.getSelectionModel().getSelectedItem().setAccountingFilesDetailsList(listOfAccDetails);
                }

                mainEm.getTransaction().commit();
                showAccountingFilesDetails(AccountingFilesTable.getSelectionModel().getSelectedItem());

            } else {
                System.out.println("dest.exists() == true edest.exists() == true");
                Alert alert = new Alert(AlertType.WARNING);
                alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
                alert.setTitle("يوجد ملف مسبقا بهذا الإسم");
                alert.setContentText("الرجاء إختيار إسم جديد");
                alert.showAndWait();
                addOpeningCycle();
            }
        }

    }

    private void copyOpeningCycleFiles(File source1, File dest1, File source2, File dest2, File source3, File dest3)
            throws IOException {

        Files.copy(source1.toPath(), dest1.toPath());
        Files.copy(source2.toPath(), dest2.toPath());
        Files.copy(source3.toPath(), dest3.toPath());

        System.out.println("incopyFileUsingJava7Files");

    }

    private void showLinkWithCycleDialog() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("البسيط للمحاسبة");
        File defaultDirectory = new File("New Data.data");
        chooser.setInitialDirectory(new File(defaultDirectory.getAbsoluteFile().getParent()));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("data", "*.data"));
        File choosenFile = chooser.showOpenDialog(accNoteBook);
        if (choosenFile != null) {
            File choosen2 = new File(choosenFile.getName().replaceFirst("[.][^.]+$", "") + ".properties");
            File choosen3 = new File(choosenFile.getName().replaceFirst("[.][^.]+$", "") + ".script");
            if (choosen2.exists() == true && choosen3.exists() == true) {
                AccountingFilesDetails newDetail = new AccountingFilesDetails();
                newDetail.setAccountingId(AccountingFilesTable.getSelectionModel().getSelectedItem());
                newDetail.setActiveStatus(false);
                newDetail.setCycleStartDate(new Date());
                newDetail.setFileBackupName(choosenFile.getName().replaceFirst("[.][^.]+$", "") + "_Backup");
                newDetail.setFileCosedFlag(false);
                newDetail.setFileName(choosenFile.getName().replaceFirst("[.][^.]+$", ""));
                newDetail.setFilePath(choosenFile.getAbsoluteFile().getParent());
                mainEm.getTransaction().begin();
                mainEm.persist(newDetail);
                if (AccountingFilesTable.getSelectionModel().getSelectedItem().getAccountingFilesDetailsList() != null) {
                    AccountingFilesTable.getSelectionModel().getSelectedItem().getAccountingFilesDetailsList().add(newDetail);
                } else {
                    List<AccountingFilesDetails> listOfAccDetails = new ArrayList<AccountingFilesDetails>();
                    listOfAccDetails.add(newDetail);
                    AccountingFilesTable.getSelectionModel().getSelectedItem().setAccountingFilesDetailsList(listOfAccDetails);
                }

                mainEm.getTransaction().commit();
                showAccountingFilesDetails(AccountingFilesTable.getSelectionModel().getSelectedItem());
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
                alert.setTitle("يوجد خطأ في ملف قاعدة البيانات المحدد");
                alert.setContentText("الرجاء اختيار ملف بيانات صالح");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void linkWithCycle() {
        AccountingFiles currAccFile = AccountingFilesTable.getSelectionModel().getSelectedItem();
        if (currAccFile == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
            alert.setTitle("لا يوجد دفتر محاسبي محدد");
            alert.setContentText("الرجاء إختيار دفتر محاسبي للمتابعة");
            alert.showAndWait();
        }
        if (currAccFile != null && !currAccFile.getAccountingFilesPassword().equals("")) {
            if (showAccountingBookPasswordConfirm(currAccFile) == true) {
                showLinkWithCycleDialog();
            }
        } else if (currAccFile != null && currAccFile.getAccountingFilesPassword().equals("")) {
            showLinkWithCycleDialog();

        }
    }

    private void showRemoveCycleConfirmation(AccountingFiles currAccFile, AccountingFilesDetails currAccFileDetail) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("تأكيد حذف الدورة المحاسبية");
        alert.setHeaderText("تحذير");
        alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);

        alert.setContentText("هل أنت متأكد من حذف الدورة المحاسبية  " + currAccFileDetail.getFileName());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("in remove cycle " + currAccFileDetail.getFileName());
            currAccFile.getAccountingFilesDetailsList().remove(currAccFileDetail);
            Connector.getMainEntityManager().getTransaction().begin();
            Connector.getMainEntityManager().remove(currAccFileDetail);
            Connector.getMainEntityManager().getTransaction().commit();

            showAccountingFilesDetails(currAccFile);
        } else {
            alert.hide();
        }
    }

    @FXML
    private void removeCycle() {
        AccountingFilesDetails currAccFileDetail = AccountingFilesDetailsTable.getSelectionModel().getSelectedItem();
        AccountingFiles currAccFile = AccountingFilesTable.getSelectionModel().getSelectedItem();
        if (currAccFileDetail == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("لا يوجد دورة محاسبية محددة");
            alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
            alert.setContentText("الرجاء تحديد دورة محاسبية ليتم إلغاءها");
            alert.showAndWait();
        }
        if (currAccFileDetail != null && currAccFile.getAccountingFilesPassword().equals("")) {
            showRemoveCycleConfirmation(currAccFile, currAccFileDetail);
        } else if (currAccFileDetail != null && !currAccFile.getAccountingFilesPassword().equals("")) {
            if (showAccountingBookPasswordConfirm(currAccFile) == true) {
                showRemoveCycleConfirmation(currAccFile, currAccFileDetail);
            }
        }

    }

    @FXML
    private void proccedToSelectedCycle() {
        AccountingFilesDetails currAccFileDetail = AccountingFilesDetailsTable.getSelectionModel().getSelectedItem();
        AccountingFiles currAccFile = AccountingFilesTable.getSelectionModel().getSelectedItem();
        
        if (currAccFileDetail== null){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("لا يوجد دورة محاسبية محددة");
            alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
            alert.setContentText("الرجاء تحديد دورة محاسبية ليتم الإنتقال إليها");
            alert.showAndWait();
        } else if (currAccFile.getAccountingFilesPassword().equals("")){
            showProceedConfirmationDialog (currAccFile, currAccFileDetail) ;
            
        }else if (!currAccFile.getAccountingFilesPassword().equals("")){
            if (showAccountingBookPasswordConfirm(currAccFile) == true){
                showProceedConfirmationDialog (currAccFile, currAccFileDetail) ;
            }
        }
        

    }
    
    public void showProceedConfirmationDialog (AccountingFiles currAccFile, AccountingFilesDetails currAccFileDetail){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("تأكيد الإنتقال إلى الدورة المحاسبية المحددة");
        alert.setHeaderText("تأكيد");
        alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);

        alert.setContentText("هل أنت متأكد من الإنتقال إلى الدورة المحاسبية  " + currAccFileDetail.getFileName());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            mainEm.getTransaction().begin();
            for (AccountingFiles af : accountingData){
                af.setAccountingFilesActiveStatus(false);
            }
            for(AccountingFilesDetails afDetail : accountingDetails){
                afDetail.setActiveStatus(false);
            }
            currAccFile.setAccountingFilesActiveStatus(true);
            currAccFileDetail.setActiveStatus(true);
            mainEm.getTransaction().commit();
            showAccountingFilesDetails(currAccFile);
            addingItems();
            Connector.closeDataConnection();
            Connector.getDataEntityManager();
            mainApp.accountingFilesStage.hide();
        } else {
            alert.hide();
        }
    }

    @FXML
    private void closeCurrentCycle() {

    }

    private void showAccountingFilesDetails(AccountingFiles newValue) {
        List<AccountingFilesDetails> listOfAccDetails = null;
        if (newValue != null) {
            listOfAccDetails = newValue.getAccountingFilesDetailsList();
        }
        if (listOfAccDetails != null) {
            accountingDetails.setAll(listOfAccDetails);
            AccountingFilesDetailsTable.setItems(accountingDetails);
        } else {
            accountingDetails.clear();
            AccountingFilesDetailsTable.setItems(accountingDetails);
        }
    }

    public class PasswordLabelCell extends TableCell<AccountingFiles, String> {

        private Label label;

        public PasswordLabelCell() {
            label = new Label();
            this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            this.setGraphic(null);
        }

        private String genDotString(int len) {
            String dots = "";

            for (int i = 0; i < len; i++) {
                dots += "\u2022";
            }

            return dots;
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                label.setText(genDotString(item.length()));
                setGraphic(label);
            } else {
                setGraphic(null);
            }
        }
    }

}
