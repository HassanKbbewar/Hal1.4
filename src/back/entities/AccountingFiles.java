package back.entities;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Hassan@Transient
 */
@Entity
@Table(name = "ACCOUNTING_FILES")
@NamedQueries({
    @NamedQuery(name = "AccountingFiles.findAll", query = "SELECT a FROM AccountingFiles a"),
    @NamedQuery(name = "AccountingFiles.findByAccountingFilesId", query = "SELECT a FROM AccountingFiles a WHERE a.accountingFilesId = :accountingFilesId"),
    @NamedQuery(name = "AccountingFiles.findByAccountingFilesName", query = "SELECT a FROM AccountingFiles a WHERE a.accountingFilesName = :accountingFilesName"),
    @NamedQuery(name = "AccountingFiles.findByAccountingFilesActiveStatus", query = "SELECT a FROM AccountingFiles a WHERE a.accountingFilesActiveStatus = :accountingFilesActiveStatus")})
public class AccountingFiles implements Serializable {

    private Integer accountingFilesId;
    private String accountingFilesName;
    private Boolean accountingFilesActiveStatus;
    private String accountingFilesPassword;
    private List<AccountingFilesDetails> accountingFilesDetailsList;
    //properties for javafx

    public AccountingFiles() {
    }

    public AccountingFiles(Integer accountingFilesId) {
        this.accountingFilesId = accountingFilesId;
    }

    public AccountingFiles(String name, String password, Boolean status) {
        this.accountingFilesName = name;
        this.accountingFilesPassword = password;
        this.accountingFilesActiveStatus = status;

    }

    @TableGenerator(name = "AccountingFilesGen", table = "MAIN_SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "ACCOUNTING_FILES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "AccountingFilesGen")
    @Id
    @Column(name = "ACCOUNTING_FILES_ID")
    public Integer getAccountingFilesId() {
        return accountingFilesId;
    }

    public void setAccountingFilesId(Integer accountingFilesId) {
        this.accountingFilesId = accountingFilesId;
    }

    @Column(name = "ACCOUNTING_FILES_NAME")
    public String getAccountingFilesName() {
        return accountingFilesName;
    }

    public void setAccountingFilesName(String accountingFilesName) {
        this.accountingFilesName = accountingFilesName;
    }

    @Column(name = "ACCOUNTING_FILES_ACTIVE_STATUS")
    public Boolean getAccountingFilesActiveStatus() {
        return accountingFilesActiveStatus;
    }

    public void setAccountingFilesActiveStatus(Boolean accountingFilesActiveStatus) {
        this.accountingFilesActiveStatus = accountingFilesActiveStatus;
    }

    @Column(name = "ACCOUNTING_FILES_PASSWORD")
    public String getAccountingFilesPassword() {
        return accountingFilesPassword;
    }

    public void setAccountingFilesPassword(String accountingFilesPassword) {
        this.accountingFilesPassword = accountingFilesPassword;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountingId")
    public List<AccountingFilesDetails> getAccountingFilesDetailsList() {
        return accountingFilesDetailsList;
    }

    public void setAccountingFilesDetailsList(List<AccountingFilesDetails> accountingFilesDetailsList) {
        this.accountingFilesDetailsList = accountingFilesDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountingFilesId != null ? accountingFilesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountingFiles)) {
            return false;
        }
        AccountingFiles other = (AccountingFiles) object;
        if ((this.accountingFilesId == null && other.accountingFilesId != null) || (this.accountingFilesId != null && !this.accountingFilesId.equals(other.accountingFilesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.AccountingFiles[ accountingFilesId=" + accountingFilesId + " ]";
    }

    /**
     * @return the accFileId
     */
    public IntegerProperty accFileIdProperty() {
        if (accountingFilesId != null) {
            return new SimpleIntegerProperty(accountingFilesId);
        } else {
            System.out.println("accFileIdProperty return null");
            return new SimpleIntegerProperty(1);
        }
    }

    /**
     * @return the accFileName
     */
    public StringProperty accFileNameProperty() {
        if (accountingFilesName != null) {
            return new SimpleStringProperty(accountingFilesName);
        } else {
            System.out.println("accFileNameProperty return null");
            return new SimpleStringProperty(null);
        }
    }

    /**
     * @return the accFilePassword
     */
    public StringProperty accFilePasswordProperty() {
        if (accountingFilesPassword != null) {
            return new SimpleStringProperty(accountingFilesPassword);
        } else {
            System.out.println("accFilePasswordProperty return null");
            return new SimpleStringProperty(null);
        }
    }

    /**
     * @return the currentAccSelectedFile
     */
    public BooleanProperty currentAccSelectedFileProperty() {
        if (accountingFilesActiveStatus != null) {
            return new SimpleBooleanProperty(accountingFilesActiveStatus);
        } else {
            return new SimpleBooleanProperty(false);
        }
    }

}
