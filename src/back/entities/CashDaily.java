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
@Table(name = "CASH_DAILY")
@NamedQueries({
    @NamedQuery(name = "CashDaily.findAll", query = "SELECT c FROM CashDaily c"),
    @NamedQuery(name = "CashDaily.findByCashDailyId", query = "SELECT c FROM CashDaily c WHERE c.cashDailyId = :cashDailyId"),
    @NamedQuery(name = "CashDaily.findByCashDailyDate", query = "SELECT c FROM CashDaily c WHERE c.cashDailyDate = :cashDailyDate"),
    @NamedQuery(name = "CashDaily.findByCashDailyTarhelStatus", query = "SELECT c FROM CashDaily c WHERE c.cashDailyTarhelStatus = :cashDailyTarhelStatus")})
public class CashDaily implements Serializable {

    private Integer cashDailyId;
    private Date cashDailyDate;
    private Boolean cashDailyTarhelStatus;
    private List<CashDailySub> cashDailySubList;
    private Daily dailyId;

    public CashDaily() {
    }

    public CashDaily(Integer cashDailyId) {
        this.cashDailyId = cashDailyId;
    }

    @TableGenerator(name = "CashDailyGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "CASH_DAILY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "CashDailyGen")
    @Id
    @Column(name = "CASH_DAILY_ID")
    public Integer getCashDailyId() {
        return cashDailyId;
    }

    public void setCashDailyId(Integer cashDailyId) {
        this.cashDailyId = cashDailyId;
    }

    @Column(name = "CASH_DAILY_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCashDailyDate() {
        return cashDailyDate;
    }

    public void setCashDailyDate(Date cashDailyDate) {
        this.cashDailyDate = cashDailyDate;
    }

    @Column(name = "CASH_DAILY_TARHEL_STATUS")
    public Boolean getCashDailyTarhelStatus() {
        return cashDailyTarhelStatus;
    }

    public void setCashDailyTarhelStatus(Boolean cashDailyTarhelStatus) {
        this.cashDailyTarhelStatus = cashDailyTarhelStatus;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cashDailyId", fetch = FetchType.LAZY)
    public List<CashDailySub> getCashDailySubList() {
        return cashDailySubList;
    }

    public void setCashDailySubList(List<CashDailySub> cashDailySubList) {
        this.cashDailySubList = cashDailySubList;
    }

    @JoinColumn(name = "DAILY_ID", referencedColumnName = "DAILY_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Daily getDailyId() {
        return dailyId;
    }

    public void setDailyId(Daily dailyId) {
        this.dailyId = dailyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cashDailyId != null ? cashDailyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashDaily)) {
            return false;
        }
        CashDaily other = (CashDaily) object;
        if ((this.cashDailyId == null && other.cashDailyId != null) || (this.cashDailyId != null && !this.cashDailyId.equals(other.cashDailyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.CashDaily[ cashDailyId=" + cashDailyId + " ]";
    }

}
