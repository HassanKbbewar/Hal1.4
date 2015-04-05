package back.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "COMMISSION_SALES_DETAILS")
@NamedQueries({
    @NamedQuery(name = "CommissionSalesDetails.findAll", query = "SELECT c FROM CommissionSalesDetails c"),
    @NamedQuery(name = "CommissionSalesDetails.findBySalesDetailId", query = "SELECT c FROM CommissionSalesDetails c WHERE c.salesDetailId = :salesDetailId"),
    @NamedQuery(name = "CommissionSalesDetails.findByPeiceCount", query = "SELECT c FROM CommissionSalesDetails c WHERE c.peiceCount = :peiceCount"),
    @NamedQuery(name = "CommissionSalesDetails.findByKindName", query = "SELECT c FROM CommissionSalesDetails c WHERE c.kindName = :kindName"),
    @NamedQuery(name = "CommissionSalesDetails.findByBoxNumber", query = "SELECT c FROM CommissionSalesDetails c WHERE c.boxNumber = :boxNumber"),
    @NamedQuery(name = "CommissionSalesDetails.findByWeight", query = "SELECT c FROM CommissionSalesDetails c WHERE c.weight = :weight"),
    @NamedQuery(name = "CommissionSalesDetails.findByPrice", query = "SELECT c FROM CommissionSalesDetails c WHERE c.price = :price"),
    @NamedQuery(name = "CommissionSalesDetails.findBySaleType", query = "SELECT c FROM CommissionSalesDetails c WHERE c.saleType = :saleType"),
    @NamedQuery(name = "CommissionSalesDetails.findByDebitSale", query = "SELECT c FROM CommissionSalesDetails c WHERE c.debitSale = :debitSale"),
    @NamedQuery(name = "CommissionSalesDetails.findByMasrof", query = "SELECT c FROM CommissionSalesDetails c WHERE c.masrof = :masrof"),
    @NamedQuery(name = "CommissionSalesDetails.findByCasheirName", query = "SELECT c FROM CommissionSalesDetails c WHERE c.casheirName = :casheirName"),
    @NamedQuery(name = "CommissionSalesDetails.findByMasrofByKilo", query = "SELECT c FROM CommissionSalesDetails c WHERE c.masrofByKilo = :masrofByKilo"),
    @NamedQuery(name = "CommissionSalesDetails.findByMasrofByBox", query = "SELECT c FROM CommissionSalesDetails c WHERE c.masrofByBox = :masrofByBox")})
public class CommissionSalesDetails implements Serializable {

    private Integer salesDetailId;
    private Integer peiceCount;
    private String kindName;
    private Integer boxNumber;
    private Integer weight;
    private Integer price;
    private String saleType;
    private Boolean debitSale;
    private Integer masrof;
    private String casheirName;
    private Integer masrofByKilo;
    private Integer masrofByBox;
    private Account accountId;
    private BuyersCustomers clientId;
    private CommissionSales commissionSalesId;

    public CommissionSalesDetails() {
    }

    public CommissionSalesDetails(Integer salesDetailId) {
        this.salesDetailId = salesDetailId;
    }

    @TableGenerator(name = "CommissionSalesDetailsGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "COMMISSION_SALES_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "CommissionSalesDetailsGen")
    @Id
    @Column(name = "SALES_DETAIL_ID")
    public Integer getSalesDetailId() {
        return salesDetailId;
    }

    public void setSalesDetailId(Integer salesDetailId) {
        this.salesDetailId = salesDetailId;
    }

    @Column(name = "PEICE_COUNT")
    public Integer getPeiceCount() {
        return peiceCount;
    }

    public void setPeiceCount(Integer peiceCount) {
        this.peiceCount = peiceCount;
    }

    @Column(name = "KIND_NAME")
    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Column(name = "BOX_NUMBER")
    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    @Column(name = "WEIGHT")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "SALE_TYPE")
    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    @Column(name = "DEBIT_SALE")
    public Boolean getDebitSale() {
        return debitSale;
    }

    public void setDebitSale(Boolean debitSale) {
        this.debitSale = debitSale;
    }

    @Column(name = "MASROF")
    public Integer getMasrof() {
        return masrof;
    }

    public void setMasrof(Integer masrof) {
        this.masrof = masrof;
    }

    @Column(name = "CASHEIR_NAME")
    public String getCasheirName() {
        return casheirName;
    }

    public void setCasheirName(String casheirName) {
        this.casheirName = casheirName;
    }

    @Column(name = "MASROF_BY_KILO")
    public Integer getMasrofByKilo() {
        return masrofByKilo;
    }

    public void setMasrofByKilo(Integer masrofByKilo) {
        this.masrofByKilo = masrofByKilo;
    }

    @Column(name = "MASROF_BY_BOX")
    public Integer getMasrofByBox() {
        return masrofByBox;
    }

    public void setMasrofByBox(Integer masrofByBox) {
        this.masrofByBox = masrofByBox;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "BUYERS_CUSTOMERS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public BuyersCustomers getClientId() {
        return clientId;
    }

    public void setClientId(BuyersCustomers clientId) {
        this.clientId = clientId;
    }

    @JoinColumn(name = "COMMISSION_SALES_ID", referencedColumnName = "COMMISSION_SALES_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public CommissionSales getCommissionSalesId() {
        return commissionSalesId;
    }

    public void setCommissionSalesId(CommissionSales commissionSalesId) {
        this.commissionSalesId = commissionSalesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesDetailId != null ? salesDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommissionSalesDetails)) {
            return false;
        }
        CommissionSalesDetails other = (CommissionSalesDetails) object;
        if ((this.salesDetailId == null && other.salesDetailId != null) || (this.salesDetailId != null && !this.salesDetailId.equals(other.salesDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.CommissionSalesDetails[ salesDetailId=" + salesDetailId + " ]";
    }

}
