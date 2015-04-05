package back.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Account.findByAccountName", query = "SELECT a FROM Account a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Account.findByAccountReturn", query = "SELECT a FROM Account a WHERE a.accountReturn = :accountReturn"),
    @NamedQuery(name = "Account.findByAccountType", query = "SELECT a FROM Account a WHERE a.accountType = :accountType"),
    @NamedQuery(name = "Account.findByAccountPosition", query = "SELECT a FROM Account a WHERE a.accountPosition = :accountPosition"),
    @NamedQuery(name = "Account.findByDebitFlag", query = "SELECT a FROM Account a WHERE a.debitFlag = :debitFlag")})
public class Account implements Serializable {

    private Integer accountId;
    private String accountName;
    private Integer accountReturn;
    private String accountType;
    private String accountPosition;
    private Boolean debitFlag;
    private List<DailyDetails> dailyDetailsList;
    private List<CashDailySub> cashDailySubList;
    private List<Cargo> cargoList;
    private Customers customers;
    private List<BuyingGoods> buyingGoodsList;
    private List<Invoices> invoicesList;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    @TableGenerator(name = "AccountGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "ACCOUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "AccountGen")
    @Id
    @Column(name = "ACCOUNT_ID")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Column(name = "ACCOUNT_NAME")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "ACCOUNT_RETURN")
    public Integer getAccountReturn() {
        return accountReturn;
    }

    public void setAccountReturn(Integer accountReturn) {
        this.accountReturn = accountReturn;
    }

    @Column(name = "ACCOUNT_TYPE")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Column(name = "ACCOUNT_POSITION")
    public String getAccountPosition() {
        return accountPosition;
    }

    public void setAccountPosition(String accountPosition) {
        this.accountPosition = accountPosition;
    }

    @Column(name = "DEBIT_FLAG")
    public Boolean getDebitFlag() {
        return debitFlag;
    }

    public void setDebitFlag(Boolean debitFlag) {
        this.debitFlag = debitFlag;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    public List<DailyDetails> getDailyDetailsList() {
        return dailyDetailsList;
    }

    public void setDailyDetailsList(List<DailyDetails> dailyDetailsList) {
        this.dailyDetailsList = dailyDetailsList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    public List<CashDailySub> getCashDailySubList() {
        return cashDailySubList;
    }

    public void setCashDailySubList(List<CashDailySub> cashDailySubList) {
        this.cashDailySubList = cashDailySubList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    public List<BuyingGoods> getBuyingGoodsList() {
        return buyingGoodsList;
    }

    public void setBuyingGoodsList(List<BuyingGoods> buyingGoodsList) {
        this.buyingGoodsList = buyingGoodsList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    public List<Invoices> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoices> invoicesList) {
        this.invoicesList = invoicesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Account[ accountId=" + accountId + " ]";
    }

}
