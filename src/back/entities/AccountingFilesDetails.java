package back.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "ACCOUNTING_FILES_DETAILS")
@NamedQueries({
    @NamedQuery(name = "AccountingFilesDetails.findAll", query = "SELECT a FROM AccountingFilesDetails a"),
    @NamedQuery(name = "AccountingFilesDetails.findByDetailId", query = "SELECT a FROM AccountingFilesDetails a WHERE a.detailId = :detailId"),
    @NamedQuery(name = "AccountingFilesDetails.findByFileName", query = "SELECT a FROM AccountingFilesDetails a WHERE a.fileName = :fileName"),
    @NamedQuery(name = "AccountingFilesDetails.findByFilePath", query = "SELECT a FROM AccountingFilesDetails a WHERE a.filePath = :filePath"),
    @NamedQuery(name = "AccountingFilesDetails.findByActiveStatus", query = "SELECT a FROM AccountingFilesDetails a WHERE a.activeStatus = :activeStatus"),
    @NamedQuery(name = "AccountingFilesDetails.findByCycleStartDate", query = "SELECT a FROM AccountingFilesDetails a WHERE a.cycleStartDate = :cycleStartDate"),
    @NamedQuery(name = "AccountingFilesDetails.findByCycleEndDate", query = "SELECT a FROM AccountingFilesDetails a WHERE a.cycleEndDate = :cycleEndDate"),
    @NamedQuery(name = "AccountingFilesDetails.findByFileBackupName", query = "SELECT a FROM AccountingFilesDetails a WHERE a.fileBackupName = :fileBackupName"),
    @NamedQuery(name = "AccountingFilesDetails.findByFileCosedFlag", query = "SELECT a FROM AccountingFilesDetails a WHERE a.fileCosedFlag = :fileCosedFlag")})
public class AccountingFilesDetails implements Serializable {

    private Integer detailId;
    private String fileName;
    private String filePath;
    private Boolean activeStatus;
    private Date cycleStartDate;
    private Date cycleEndDate;
    private String fileBackupName;
    private Boolean fileCosedFlag;
    private AccountingFiles accountingId;

    public AccountingFilesDetails() {
    }

    public AccountingFilesDetails(Integer detailId) {
        this.detailId = detailId;
    }

    @TableGenerator(name = "AccountingFilesDetailsGen", table = "MAIN_SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "ACCOUNTING_FILES_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "AccountingFilesDetailsGen")
    @Id
    @Column(name = "DETAIL_ID")
    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "FILE_PATH")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Column(name = "ACTIVE_STATUS")
    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Column(name = "CYCLE_START_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCycleStartDate() {
        return cycleStartDate;
    }

    public void setCycleStartDate(Date cycleStartDate) {
        this.cycleStartDate = cycleStartDate;
    }

    @Column(name = "CYCLE_END_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCycleEndDate() {
        return cycleEndDate;
    }

    public void setCycleEndDate(Date cycleEndDate) {
        this.cycleEndDate = cycleEndDate;
    }

    @Column(name = "FILE_BACKUP_NAME")
    public String getFileBackupName() {
        return fileBackupName;
    }

    public void setFileBackupName(String fileBackupName) {
        this.fileBackupName = fileBackupName;
    }

    @Column(name = "FILE_COSED_FLAG")
    public Boolean getFileCosedFlag() {
        return fileCosedFlag;
    }

    public void setFileCosedFlag(Boolean fileCosedFlag) {
        this.fileCosedFlag = fileCosedFlag;
    }

    @JoinColumn(name = "ACCOUNTING_ID", referencedColumnName = "ACCOUNTING_FILES_ID")
    @ManyToOne(optional = false)
    public AccountingFiles getAccountingId() {
        return accountingId;
    }

    public void setAccountingId(AccountingFiles accountingId) {
        this.accountingId = accountingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailId != null ? detailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountingFilesDetails)) {
            return false;
        }
        AccountingFilesDetails other = (AccountingFilesDetails) object;
        if ((this.detailId == null && other.detailId != null) || (this.detailId != null && !this.detailId.equals(other.detailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.AccountingFilesDetails[ detailId=" + detailId + " ]";
    }

    public BooleanProperty currentAccSelectedFileProperty() {
        return new SimpleBooleanProperty(activeStatus);
    }

    public ObjectProperty<LocalDate> accFilesDetailsStartDateProperty() {
        Instant instant = null;
        if (cycleStartDate != null) {
            instant = Instant.ofEpochMilli(cycleStartDate.getTime());
            return new SimpleObjectProperty<LocalDate>(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate());
        }
        else
            return new SimpleObjectProperty<LocalDate>(null);
    }

    public ObjectProperty<LocalDate> accFilesDetailsEndDateProperty() {
        Instant instant = null;
        if (cycleEndDate != null) {
            instant = Instant.ofEpochMilli(cycleEndDate.getTime());
            return new SimpleObjectProperty<LocalDate>(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate());
        }
        else
            return new SimpleObjectProperty<LocalDate>(null);
    }

    public StringProperty accountingFilesDetailsFileNameProperty() {
        return new SimpleStringProperty(fileName);
    }

    public StringProperty accountingFilesDetailsFileLocationProperty() {
        return new SimpleStringProperty(filePath);
    }

    public StringProperty accountingFilesDetailsFileBackupProperty() {
        return new SimpleStringProperty(fileBackupName);
    }

    public BooleanProperty accClosedFileProperty() {
        return new SimpleBooleanProperty(fileCosedFlag);
    }

}
