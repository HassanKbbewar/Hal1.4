package back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "MERGED_INVOICES")
@NamedQueries({
    @NamedQuery(name = "MergedInvoices.findAll", query = "SELECT m FROM MergedInvoices m"),
    @NamedQuery(name = "MergedInvoices.findByMergeId", query = "SELECT m FROM MergedInvoices m WHERE m.mergeId = :mergeId"),
    @NamedQuery(name = "MergedInvoices.findByMergeName", query = "SELECT m FROM MergedInvoices m WHERE m.mergeName = :mergeName"),
    @NamedQuery(name = "MergedInvoices.findByMergeDate", query = "SELECT m FROM MergedInvoices m WHERE m.mergeDate = :mergeDate"),
    @NamedQuery(name = "MergedInvoices.findByMergeNote", query = "SELECT m FROM MergedInvoices m WHERE m.mergeNote = :mergeNote")})
public class MergedInvoices implements Serializable {

    private Integer mergeId;
    private String mergeName;
    private Date mergeDate;
    private String mergeNote;
    private List<Invoices> invoicesList;
    
    public MergedInvoices() {
    }

    public MergedInvoices(Integer mergeId) {
        this.mergeId = mergeId;
    }

    @TableGenerator(name = "MergedInvoicesGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "MERGED_INVOICES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MergedInvoicesGen")
    @Id
    @Column(name = "MERGE_ID")
    public Integer getMergeId() {
        return mergeId;
    }

    public void setMergeId(Integer mergeId) {
        this.mergeId = mergeId;
    }

    @Column(name = "MERGE_NAME")
    public String getMergeName() {
        return mergeName;
    }

    public void setMergeName(String mergeName) {
        this.mergeName = mergeName;
    }

    @Column(name = "MERGE_DATE")
    @Temporal(TemporalType.DATE)
    public Date getMergeDate() {
        return mergeDate;
    }

    public void setMergeDate(Date mergeDate) {
        this.mergeDate = mergeDate;
    }

    @Column(name = "MERGE_NOTE")
    public String getMergeNote() {
        return mergeNote;
    }

    public void setMergeNote(String mergeNote) {
        this.mergeNote = mergeNote;
    }

    @OneToMany(mappedBy = "mergeId", fetch = FetchType.LAZY)
    public List<Invoices> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoices> invoicesList) {
        this.invoicesList = invoicesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mergeId != null ? mergeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MergedInvoices)) {
            return false;
        }
        MergedInvoices other = (MergedInvoices) object;
        if ((this.mergeId == null && other.mergeId != null) || (this.mergeId != null && !this.mergeId.equals(other.mergeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.MergedInvoices[ mergeId=" + mergeId + " ]";
    }

}
