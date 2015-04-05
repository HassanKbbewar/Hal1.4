package back.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "MAIN_SEQUENCE")
@NamedQueries({
    @NamedQuery(name = "MainSequence.findAll", query = "SELECT m FROM MainSequence m"),
    @NamedQuery(name = "MainSequence.findBySeqName", query = "SELECT m FROM MainSequence m WHERE m.seqName = :seqName"),
    @NamedQuery(name = "MainSequence.findBySeqCount", query = "SELECT m FROM MainSequence m WHERE m.seqCount = :seqCount")})
public class MainSequence implements Serializable {

    private String seqName;
    private Integer seqCount;

    public MainSequence() {
    }

    public MainSequence(String seqName) {
        this.seqName = seqName;
    }

    @Id
    @Column(name = "SEQ_NAME")
    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    @Column(name = "SEQ_COUNT")
    public Integer getSeqCount() {
        return seqCount;
    }

    public void setSeqCount(Integer seqCount) {
        this.seqCount = seqCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqName != null ? seqName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MainSequence)) {
            return false;
        }
        MainSequence other = (MainSequence) object;
        if ((this.seqName == null && other.seqName != null) || (this.seqName != null && !this.seqName.equals(other.seqName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.MainSequence[ seqName=" + seqName + " ]";
    }

}
