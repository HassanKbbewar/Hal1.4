package back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "COMMISSION_SALES")
@NamedQueries({
    @NamedQuery(name = "CommissionSales.findAll", query = "SELECT c FROM CommissionSales c"),
    @NamedQuery(name = "CommissionSales.findByCommissionSalesId", query = "SELECT c FROM CommissionSales c WHERE c.commissionSalesId = :commissionSalesId"),
    @NamedQuery(name = "CommissionSales.findByCommissionSalesDate", query = "SELECT c FROM CommissionSales c WHERE c.commissionSalesDate = :commissionSalesDate"),
    @NamedQuery(name = "CommissionSales.findByTarhelStatus", query = "SELECT c FROM CommissionSales c WHERE c.tarhelStatus = :tarhelStatus")})
public class CommissionSales implements Serializable {

    private Integer commissionSalesId;
    private Date commissionSalesDate;
    private Boolean tarhelStatus;
    private Daily dailyId;
    private List<CommissionSalesDetails> commissionSalesDetailsList;
    private List<Invoices> invoicesList;

    public CommissionSales() {
    }

    public CommissionSales(Integer commissionSalesId) {
        this.commissionSalesId = commissionSalesId;
    }

    public CommissionSales(Integer commissionSalesId, Date commissionSalesDate) {
        this.commissionSalesId = commissionSalesId;
        this.commissionSalesDate = commissionSalesDate;
    }

    @TableGenerator(name = "CommissionSalesGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "COMMISSION_SALES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "CommissionSalesGen")
    @Id
    @Column(name = "COMMISSION_SALES_ID")
    public Integer getCommissionSalesId() {
        return commissionSalesId;
    }

    public void setCommissionSalesId(Integer commissionSalesId) {
        this.commissionSalesId = commissionSalesId;
    }

    @Column(name = "COMMISSION_SALES_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCommissionSalesDate() {
        return commissionSalesDate;
    }

    public void setCommissionSalesDate(Date commissionSalesDate) {
        this.commissionSalesDate = commissionSalesDate;
    }

    @Column(name = "TARHEL_STATUS")
    public Boolean getTarhelStatus() {
        return tarhelStatus;
    }

    public void setTarhelStatus(Boolean tarhelStatus) {
        this.tarhelStatus = tarhelStatus;
    }

    @JoinColumn(name = "DAILY_ID", referencedColumnName = "DAILY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public Daily getDailyId() {
        return dailyId;
    }

    public void setDailyId(Daily dailyId) {
        this.dailyId = dailyId;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commissionSalesId", fetch = FetchType.LAZY)
    public List<CommissionSalesDetails> getCommissionSalesDetailsList() {
        return commissionSalesDetailsList;
    }

    public void setCommissionSalesDetailsList(List<CommissionSalesDetails> commissionSalesDetailsList) {
        this.commissionSalesDetailsList = commissionSalesDetailsList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commissionSalesId", fetch = FetchType.LAZY)
    public List<Invoices> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoices> invoicesList) {
        this.invoicesList = invoicesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commissionSalesId != null ? commissionSalesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommissionSales)) {
            return false;
        }
        CommissionSales other = (CommissionSales) object;
        if ((this.commissionSalesId == null && other.commissionSalesId != null) || (this.commissionSalesId != null && !this.commissionSalesId.equals(other.commissionSalesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.CommissionSales[ commissionSalesId=" + commissionSalesId + " ]";
    }

}
