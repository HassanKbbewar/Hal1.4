package back.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "BALANCE")
@NamedQueries({
    @NamedQuery(name = "Balance.findAll", query = "SELECT b FROM Balance b"),
    @NamedQuery(name = "Balance.findByBalanceId", query = "SELECT b FROM Balance b WHERE b.balanceId = :balanceId"),
    @NamedQuery(name = "Balance.findByAccountId", query = "SELECT b FROM Balance b WHERE b.accountId = :accountId"),
    @NamedQuery(name = "Balance.findByAccountName", query = "SELECT b FROM Balance b WHERE b.accountName = :accountName"),
    @NamedQuery(name = "Balance.findByFinalCredit", query = "SELECT b FROM Balance b WHERE b.finalCredit = :finalCredit"),
    @NamedQuery(name = "Balance.findByFinalDebit", query = "SELECT b FROM Balance b WHERE b.finalDebit = :finalDebit")})
public class Balance implements Serializable {

    private Integer balanceId;
    private Integer accountId;
    private String accountName;
    private Integer finalCredit;
    private Integer finalDebit;

    public Balance() {
    }

    public Balance(Integer balanceId) {
        this.balanceId = balanceId;
    }

    @TableGenerator(name = "BalanceGen", table = "MAIN_SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "BALANCE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "BalanceGen")
    @Id
    @Column(name = "BALANCE_ID")
    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    @Column(name = "ACCOUNT_ID")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Column(name = "ACCOUNT_NAME")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "FINAL_CREDIT")
    public Integer getFinalCredit() {
        return finalCredit;
    }

    public void setFinalCredit(Integer finalCredit) {
        this.finalCredit = finalCredit;
    }

    @Column(name = "FINAL_DEBIT")
    public Integer getFinalDebit() {
        return finalDebit;
    }

    public void setFinalDebit(Integer finalDebit) {
        this.finalDebit = finalDebit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (balanceId != null ? balanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balance)) {
            return false;
        }
        Balance other = (Balance) object;
        if ((this.balanceId == null && other.balanceId != null) || (this.balanceId != null && !this.balanceId.equals(other.balanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Balance[ balanceId=" + balanceId + " ]";
    }

}
