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
@Table(name = "DAILY_DETAILS")
@NamedQueries({
    @NamedQuery(name = "DailyDetails.findAll", query = "SELECT d FROM DailyDetails d"),
    @NamedQuery(name = "DailyDetails.findByDailyDetailId", query = "SELECT d FROM DailyDetails d WHERE d.dailyDetailId = :dailyDetailId"),
    @NamedQuery(name = "DailyDetails.findByDailyDebit", query = "SELECT d FROM DailyDetails d WHERE d.dailyDebit = :dailyDebit"),
    @NamedQuery(name = "DailyDetails.findByDailyCredit", query = "SELECT d FROM DailyDetails d WHERE d.dailyCredit = :dailyCredit"),
    @NamedQuery(name = "DailyDetails.findByDailyDetails", query = "SELECT d FROM DailyDetails d WHERE d.dailyDetails = :dailyDetails")})
public class DailyDetails implements Serializable {

    private Integer dailyDetailId;
    private Integer dailyDebit;
    private Integer dailyCredit;
    private String dailyDetails;
    private Account accountId;
    private Daily dailyId;

    public DailyDetails() {
    }

    public DailyDetails(Integer dailyDetailId) {
        this.dailyDetailId = dailyDetailId;
    }

    @TableGenerator(name = "DailyDetailsGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "DAILY_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "DailyDetailsGen")
    @Id
    @Column(name = "DAILY_DETAIL_ID")
    public Integer getDailyDetailId() {
        return dailyDetailId;
    }

    public void setDailyDetailId(Integer dailyDetailId) {
        this.dailyDetailId = dailyDetailId;
    }

    @Column(name = "DAILY_DEBIT")
    public Integer getDailyDebit() {
        return dailyDebit;
    }

    public void setDailyDebit(Integer dailyDebit) {
        this.dailyDebit = dailyDebit;
    }

    @Column(name = "DAILY_CREDIT")
    public Integer getDailyCredit() {
        return dailyCredit;
    }

    public void setDailyCredit(Integer dailyCredit) {
        this.dailyCredit = dailyCredit;
    }

    @Column(name = "DAILY_DETAILS")
    public String getDailyDetails() {
        return dailyDetails;
    }

    public void setDailyDetails(String dailyDetails) {
        this.dailyDetails = dailyDetails;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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
        hash += (dailyDetailId != null ? dailyDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DailyDetails)) {
            return false;
        }
        DailyDetails other = (DailyDetails) object;
        if ((this.dailyDetailId == null && other.dailyDetailId != null) || (this.dailyDetailId != null && !this.dailyDetailId.equals(other.dailyDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.DailyDetails[ dailyDetailId=" + dailyDetailId + " ]";
    }

}
