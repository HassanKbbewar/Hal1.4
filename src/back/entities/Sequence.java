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
@Table(name = "SEQUENCE")
@NamedQueries({
    @NamedQuery(name = "Sequence.findAll", query = "SELECT s FROM Sequence s"),
    @NamedQuery(name = "Sequence.findBySeqName", query = "SELECT s FROM Sequence s WHERE s.seqName = :seqName"),
    @NamedQuery(name = "Sequence.findBySeqCount", query = "SELECT s FROM Sequence s WHERE s.seqCount = :seqCount")})
public class Sequence implements Serializable {

    private String seqName;
    private Integer seqCount;

    public Sequence() {
    }

    public Sequence(String seqName) {
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
        if (!(object instanceof Sequence)) {
            return false;
        }
        Sequence other = (Sequence) object;
        if ((this.seqName == null && other.seqName != null) || (this.seqName != null && !this.seqName.equals(other.seqName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Sequence[ seqName=" + seqName + " ]";
    }

}
