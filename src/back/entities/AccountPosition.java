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
@Table(name = "ACCOUNT_POSITION")
@NamedQueries({
    @NamedQuery(name = "AccountPosition.findAll", query = "SELECT a FROM AccountPosition a"),
    @NamedQuery(name = "AccountPosition.findByAccountPositionId", query = "SELECT a FROM AccountPosition a WHERE a.accountPositionId = :accountPositionId"),
    @NamedQuery(name = "AccountPosition.findByAccountPositionName", query = "SELECT a FROM AccountPosition a WHERE a.accountPositionName = :accountPositionName")})
public class AccountPosition implements Serializable {

    private Integer accountPositionId;
    private String accountPositionName;

    public AccountPosition() {
    }

    public AccountPosition(Integer accountPositionId) {
        this.accountPositionId = accountPositionId;
    }

    @Id
    @Column(name = "ACCOUNT_POSITION_ID")
    public Integer getAccountPositionId() {
        return accountPositionId;
    }

    public void setAccountPositionId(Integer accountPositionId) {
        this.accountPositionId = accountPositionId;
    }

    @Column(name = "ACCOUNT_POSITION_NAME")
    public String getAccountPositionName() {
        return accountPositionName;
    }

    public void setAccountPositionName(String accountPositionName) {
        this.accountPositionName = accountPositionName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountPositionId != null ? accountPositionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountPosition)) {
            return false;
        }
        AccountPosition other = (AccountPosition) object;
        if ((this.accountPositionId == null && other.accountPositionId != null) || (this.accountPositionId != null && !this.accountPositionId.equals(other.accountPositionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.AccountPosition[ accountPositionId=" + accountPositionId + " ]";
    }

}
