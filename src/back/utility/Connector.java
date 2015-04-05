package back.utility;

import back.entities.AccountingFiles;
import back.entities.AccountingFilesDetails;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hassan
 */
public class Connector {

    private static EntityManagerFactory mainEmf;
    private static EntityManager mainEm;
    private static EntityManagerFactory dataEmf;
    private static EntityManager dataEm;

    public static synchronized EntityManager getMainEntityManager() {

        if (mainEmf == null) {

            Map<String, String> properties = new HashMap<String, String>();

            properties.put("javax.persistence.jdbc.url", "jdbc:hsqldb:file:Main Hal;ifexists=true;shutdown=true");
            properties.put("javax.persistence.jdbc.password", "Hassan");
            properties.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbcDriver");
            properties.put("javax.persistence.jdbc.user", "Hassan");
            mainEmf = Persistence.createEntityManagerFactory("HalPU", properties);
            mainEm = mainEmf.createEntityManager();
            System.out.println("in getMainEntityManager in getMainEntityManager in getMainEntityManager ");

        }
        return mainEm;
    }

    public static synchronized EntityManager getDataEntityManager() {
        List<AccountingFiles> accountingList = null;
        List<AccountingFilesDetails> details = null;
        if (dataEmf == null) {
            System.out.println("in  synchronized EntityManager getDataEntityManager() ");
            Map<String, String> properties = new HashMap<String, String>();
            properties.put("javax.persistence.jdbc.password", "Hassan");
            properties.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbcDriver");
            properties.put("javax.persistence.jdbc.user", "Hassan");
            accountingList = getMainEntityManager().createNamedQuery("AccountingFiles.findAll").getResultList();
            if (accountingList.isEmpty() == false) {
                for (AccountingFiles files : accountingList) {
                    if (files.getAccountingFilesActiveStatus() == true) {
                        details = files.getAccountingFilesDetailsList();
                    }
                }
                if (details.isEmpty() == false) {
                    for (AccountingFilesDetails detail : details) {
                        if (detail.getActiveStatus() == true) {
                            properties.put("javax.persistence.jdbc.url", "jdbc:hsqldb:file:" + detail.getFilePath() + "\\" + detail.getFileName() + ";ifexists=true" + ";shutdown=true");
                            if (new File(detail.getFilePath() + "\\" + detail.getFileName() + ".data").exists() == true
                                    && new File(detail.getFilePath() + "\\" + detail.getFileName() + ".script").exists() == true
                                    && new File(detail.getFilePath() + "\\" + detail.getFileName() + ".properties").exists() == true) {
                                dataEmf = Persistence.createEntityManagerFactory("HalPU", properties);
                                dataEm = dataEmf.createEntityManager();
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("خطأ في ملف الدورة المحددة");
                                alert.setHeaderText("تحذير");
                                alert.getDialogPane().nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
                                alert.setContentText("الرجاء التأكد من وجود ملفات الدورة المحددة");
                                alert.show();
                            }

                        }
                    }
                }

            }

            System.out.println("in getDataEntityManager in getDataEntityManager in getDataEntityManager in getDataEntityManager ");

        }
        return dataEm;
    }

    public static void closeConnections() {
        if (mainEm != null && mainEm.isOpen() == true) {
            mainEm.close();
        }
        if (mainEmf != null && mainEmf.isOpen() == true) {
            mainEmf.close();
        }
        if (dataEm != null && dataEm.isOpen() == true) {
            dataEm.close();
        }
        if (dataEmf != null && dataEmf.isOpen() == true) {
            dataEmf.close();
        }

    }

    public static void closeDataConnection() {
        if (dataEm != null && dataEm.isOpen() == true) {
            System.out.println("in closeDataConnection closeDataConnection  dataEmdataEmdataEmdataEm ");
            dataEm.close();
            dataEm = null;
        }
        if (dataEmf != null && dataEmf.isOpen() == true) {
            System.out.println("in closeDataConnection closeDataConnection  dataEmfffffffffffffffffffffffffffffffffff ");
            dataEmf.close();
            dataEmf = null;
        }

    }

}
