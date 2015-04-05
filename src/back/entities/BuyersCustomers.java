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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "BUYERS_CUSTOMERS")
@NamedQueries({
    @NamedQuery(name = "BuyersCustomers.findAll", query = "SELECT b FROM BuyersCustomers b"),
    @NamedQuery(name = "BuyersCustomers.findByBuyersCustomersId", query = "SELECT b FROM BuyersCustomers b WHERE b.buyersCustomersId = :buyersCustomersId"),
    @NamedQuery(name = "BuyersCustomers.findByBuyersCustomersName", query = "SELECT b FROM BuyersCustomers b WHERE b.buyersCustomersName = :buyersCustomersName"),
    @NamedQuery(name = "BuyersCustomers.findByBuyersCustomersCity", query = "SELECT b FROM BuyersCustomers b WHERE b.buyersCustomersCity = :buyersCustomersCity"),
    @NamedQuery(name = "BuyersCustomers.findByBuyersCustomersType", query = "SELECT b FROM BuyersCustomers b WHERE b.buyersCustomersType = :buyersCustomersType"),
    @NamedQuery(name = "BuyersCustomers.findByBuyersCustomersFreezStatus", query = "SELECT b FROM BuyersCustomers b WHERE b.buyersCustomersFreezStatus = :buyersCustomersFreezStatus")})
public class BuyersCustomers implements Serializable {

    private Integer buyersCustomersId;
    private String buyersCustomersName;
    private String buyersCustomersResponsebleName;
    private String buyersCustomersPhone1;
    private String buyersCustomersPhone2;
    private String buyersCustomersFax;
    private String buyersCustomersEmail;
    private Integer buyersCustomersLimit;
    private String buyersCustomersCity;
    private String buyersCustomersAddress;
    private String buyersCustomersNote;
    private String buyersCustomersType;
    private Boolean buyersCustomersFreezStatus;
    private List<DebitCollect> debitCollectList;
    private List<CommissionSalesDetails> commissionSalesDetailsList;

    public BuyersCustomers() {
    }

    public BuyersCustomers(Integer buyersCustomersId) {
        this.buyersCustomersId = buyersCustomersId;
    }

    @TableGenerator(name = "BuyersCustomersGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "BUYERS_CUSTOMERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "BuyersCustomersGen")
    @Id
    @Column(name = "BUYERS_CUSTOMERS_ID")
    public Integer getBuyersCustomersId() {
        return buyersCustomersId;
    }

    public void setBuyersCustomersId(Integer buyersCustomersId) {
        this.buyersCustomersId = buyersCustomersId;
    }

    @Column(name = "BUYERS_CUSTOMERS_NAME")
    public String getBuyersCustomersName() {
        return buyersCustomersName;
    }

    public void setBuyersCustomersName(String buyersCustomersName) {
        this.buyersCustomersName = buyersCustomersName;
    }

    @Column(name = "BUYERS_CUSTOMERS_RESPONSEBLE_NAME")
    public String getBuyersCustomersResponsebleName() {
        return buyersCustomersResponsebleName;
    }

    public void setBuyersCustomersResponsebleName(String buyersCustomersResponsebleName) {
        this.buyersCustomersResponsebleName = buyersCustomersResponsebleName;
    }

    @Column(name = "BUYERS_CUSTOMERS_PHONE1")
    public String getBuyersCustomersPhone1() {
        return buyersCustomersPhone1;
    }

    public void setBuyersCustomersPhone1(String buyersCustomersPhone1) {
        this.buyersCustomersPhone1 = buyersCustomersPhone1;
    }

    @Column(name = "BUYERS_CUSTOMERS_PHONE2")
    public String getBuyersCustomersPhone2() {
        return buyersCustomersPhone2;
    }

    public void setBuyersCustomersPhone2(String buyersCustomersPhone2) {
        this.buyersCustomersPhone2 = buyersCustomersPhone2;
    }

    @Column(name = "BUYERS_CUSTOMERS_FAX")
    public String getBuyersCustomersFax() {
        return buyersCustomersFax;
    }

    public void setBuyersCustomersFax(String buyersCustomersFax) {
        this.buyersCustomersFax = buyersCustomersFax;
    }

    @Column(name = "BUYERS_CUSTOMERS_EMAIL")
    public String getBuyersCustomersEmail() {
        return buyersCustomersEmail;
    }

    public void setBuyersCustomersEmail(String buyersCustomersEmail) {
        this.buyersCustomersEmail = buyersCustomersEmail;
    }

    @Column(name = "BUYERS_CUSTOMERS_LIMIT")
    public Integer getBuyersCustomersLimit() {
        return buyersCustomersLimit;
    }

    public void setBuyersCustomersLimit(Integer buyersCustomersLimit) {
        this.buyersCustomersLimit = buyersCustomersLimit;
    }

    @Column(name = "BUYERS_CUSTOMERS_CITY")
    public String getBuyersCustomersCity() {
        return buyersCustomersCity;
    }

    public void setBuyersCustomersCity(String buyersCustomersCity) {
        this.buyersCustomersCity = buyersCustomersCity;
    }

    @Column(name = "BUYERS_CUSTOMERS_ADDRESS")
    public String getBuyersCustomersAddress() {
        return buyersCustomersAddress;
    }

    public void setBuyersCustomersAddress(String buyersCustomersAddress) {
        this.buyersCustomersAddress = buyersCustomersAddress;
    }

    @Column(name = "BUYERS_CUSTOMERS_NOTE")
    public String getBuyersCustomersNote() {
        return buyersCustomersNote;
    }

    public void setBuyersCustomersNote(String buyersCustomersNote) {
        this.buyersCustomersNote = buyersCustomersNote;
    }

    @Column(name = "BUYERS_CUSTOMERS_TYPE")
    public String getBuyersCustomersType() {
        return buyersCustomersType;
    }

    public void setBuyersCustomersType(String buyersCustomersType) {
        this.buyersCustomersType = buyersCustomersType;
    }

    @Column(name = "BUYERS_CUSTOMERS_FREEZ_STATUS")
    public Boolean getBuyersCustomersFreezStatus() {
        return buyersCustomersFreezStatus;
    }

    public void setBuyersCustomersFreezStatus(Boolean buyersCustomersFreezStatus) {
        this.buyersCustomersFreezStatus = buyersCustomersFreezStatus;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    public List<DebitCollect> getDebitCollectList() {
        return debitCollectList;
    }

    public void setDebitCollectList(List<DebitCollect> debitCollectList) {
        this.debitCollectList = debitCollectList;
    }

    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    public List<CommissionSalesDetails> getCommissionSalesDetailsList() {
        return commissionSalesDetailsList;
    }

    public void setCommissionSalesDetailsList(List<CommissionSalesDetails> commissionSalesDetailsList) {
        this.commissionSalesDetailsList = commissionSalesDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buyersCustomersId != null ? buyersCustomersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyersCustomers)) {
            return false;
        }
        BuyersCustomers other = (BuyersCustomers) object;
        if ((this.buyersCustomersId == null && other.buyersCustomersId != null) || (this.buyersCustomersId != null && !this.buyersCustomersId.equals(other.buyersCustomersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.BuyersCustomers[ buyersCustomersId=" + buyersCustomersId + " ]";
    }

}
