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
@Table(name = "DAILY")
@NamedQueries({
    @NamedQuery(name = "Daily.findAll", query = "SELECT d FROM Daily d"),
    @NamedQuery(name = "Daily.findByDailyId", query = "SELECT d FROM Daily d WHERE d.dailyId = :dailyId"),
    @NamedQuery(name = "Daily.findByDailyDate", query = "SELECT d FROM Daily d WHERE d.dailyDate = :dailyDate"),
    @NamedQuery(name = "Daily.findByDailyNote", query = "SELECT d FROM Daily d WHERE d.dailyNote = :dailyNote"),
    @NamedQuery(name = "Daily.findByDailyType", query = "SELECT d FROM Daily d WHERE d.dailyType = :dailyType"),
    @NamedQuery(name = "Daily.findByDailyInvoiceNumber", query = "SELECT d FROM Daily d WHERE d.dailyInvoiceNumber = :dailyInvoiceNumber")})
public class Daily implements Serializable {

    private Integer dailyId;
    private Date dailyDate;
    private String dailyNote;
    private Integer dailyType;
    private Integer dailyInvoiceNumber;
    private List<DailyDetails> dailyDetailsList;

    public Daily() {
    }

    public Daily(Integer dailyId) {
        this.dailyId = dailyId;
    }

    @TableGenerator(name = "DailyGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "DAILY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "DailyGen")
    @Id
    @Column(name = "DAILY_ID")
    public Integer getDailyId() {
        return dailyId;
    }

    public void setDailyId(Integer dailyId) {
        this.dailyId = dailyId;
    }

    @Column(name = "DAILY_DATE")
    @Temporal(TemporalType.DATE)
    public Date getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(Date dailyDate) {
        this.dailyDate = dailyDate;
    }

    @Column(name = "DAILY_NOTE")
    public String getDailyNote() {
        return dailyNote;
    }

    public void setDailyNote(String dailyNote) {
        this.dailyNote = dailyNote;
    }

    @Column(name = "DAILY_TYPE")
    public Integer getDailyType() {
        return dailyType;
    }

    public void setDailyType(Integer dailyType) {
        this.dailyType = dailyType;
    }

    @Column(name = "DAILY_INVOICE_NUMBER")
    public Integer getDailyInvoiceNumber() {
        return dailyInvoiceNumber;
    }

    public void setDailyInvoiceNumber(Integer dailyInvoiceNumber) {
        this.dailyInvoiceNumber = dailyInvoiceNumber;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dailyId", fetch = FetchType.LAZY)
    public List<DailyDetails> getDailyDetailsList() {
        return dailyDetailsList;
    }

    public void setDailyDetailsList(List<DailyDetails> dailyDetailsList) {
        this.dailyDetailsList = dailyDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dailyId != null ? dailyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Daily)) {
            return false;
        }
        Daily other = (Daily) object;
        if ((this.dailyId == null && other.dailyId != null) || (this.dailyId != null && !this.dailyId.equals(other.dailyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Daily[ dailyId=" + dailyId + " ]";
    }

}
