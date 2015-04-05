package back.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "DEBIT_COLLECT")
@NamedQueries({
    @NamedQuery(name = "DebitCollect.findAll", query = "SELECT d FROM DebitCollect d"),
    @NamedQuery(name = "DebitCollect.findByDebitCollectId", query = "SELECT d FROM DebitCollect d WHERE d.debitCollectId = :debitCollectId"),
    @NamedQuery(name = "DebitCollect.findByDebitValue", query = "SELECT d FROM DebitCollect d WHERE d.debitValue = :debitValue"),
    @NamedQuery(name = "DebitCollect.findByDebitDate", query = "SELECT d FROM DebitCollect d WHERE d.debitDate = :debitDate"),
    @NamedQuery(name = "DebitCollect.findByDebitNote", query = "SELECT d FROM DebitCollect d WHERE d.debitNote = :debitNote")})
public class DebitCollect implements Serializable {

    private Integer debitCollectId;
    private Integer debitValue;
    private Date debitDate;
    private String debitNote;
    private BuyersCustomers clientId;
    private CommissionSales commissionSalesId;

    public DebitCollect() {
    }

    public DebitCollect(Integer debitCollectId) {
        this.debitCollectId = debitCollectId;
    }

    @TableGenerator(name = "DebitCollectGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "DEBIT_COLLECT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "DebitCollectGen")
    @Id
    @Column(name = "DEBIT_COLLECT_ID")
    public Integer getDebitCollectId() {
        return debitCollectId;
    }

    public void setDebitCollectId(Integer debitCollectId) {
        this.debitCollectId = debitCollectId;
    }

    @Column(name = "DEBIT_VALUE")
    public Integer getDebitValue() {
        return debitValue;
    }

    public void setDebitValue(Integer debitValue) {
        this.debitValue = debitValue;
    }

    @Column(name = "DEBIT_DATE")
    @Temporal(TemporalType.DATE)
    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    @Column(name = "DEBIT_NOTE")
    public String getDebitNote() {
        return debitNote;
    }

    public void setDebitNote(String debitNote) {
        this.debitNote = debitNote;
    }

    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "BUYERS_CUSTOMERS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
        hash += (debitCollectId != null ? debitCollectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DebitCollect)) {
            return false;
        }
        DebitCollect other = (DebitCollect) object;
        if ((this.debitCollectId == null && other.debitCollectId != null) || (this.debitCollectId != null && !this.debitCollectId.equals(other.debitCollectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.DebitCollect[ debitCollectId=" + debitCollectId + " ]";
    }

}
