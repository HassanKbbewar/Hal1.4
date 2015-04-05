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
@Table(name = "CASH_DAILY_SUB")
@NamedQueries({
    @NamedQuery(name = "CashDailySub.findAll", query = "SELECT c FROM CashDailySub c"),
    @NamedQuery(name = "CashDailySub.findByCashSubId", query = "SELECT c FROM CashDailySub c WHERE c.cashSubId = :cashSubId"),
    @NamedQuery(name = "CashDailySub.findByBoxCredit", query = "SELECT c FROM CashDailySub c WHERE c.boxCredit = :boxCredit"),
    @NamedQuery(name = "CashDailySub.findByBoxDebit", query = "SELECT c FROM CashDailySub c WHERE c.boxDebit = :boxDebit"),
    @NamedQuery(name = "CashDailySub.findByNote", query = "SELECT c FROM CashDailySub c WHERE c.note = :note")})
public class CashDailySub implements Serializable {

    private Integer cashSubId;
    private Integer boxCredit;
    private Integer boxDebit;
    private String note;
    private Account accountId;
    private CashDaily cashDailyId;

    public CashDailySub() {
    }

    public CashDailySub(Integer cashSubId) {
        this.cashSubId = cashSubId;
    }

    @TableGenerator(name = "CashDailySubGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "CASH_DAILY_SUB_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "CashDailySubGen")
    @Id
    @Column(name = "CASH_SUB_ID")
    public Integer getCashSubId() {
        return cashSubId;
    }

    public void setCashSubId(Integer cashSubId) {
        this.cashSubId = cashSubId;
    }

    @Column(name = "BOX_CREDIT")
    public Integer getBoxCredit() {
        return boxCredit;
    }

    public void setBoxCredit(Integer boxCredit) {
        this.boxCredit = boxCredit;
    }

    @Column(name = "BOX_DEBIT")
    public Integer getBoxDebit() {
        return boxDebit;
    }

    public void setBoxDebit(Integer boxDebit) {
        this.boxDebit = boxDebit;
    }

    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @JoinColumn(name = "CASH_DAILY_ID", referencedColumnName = "CASH_DAILY_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public CashDaily getCashDailyId() {
        return cashDailyId;
    }

    public void setCashDailyId(CashDaily cashDailyId) {
        this.cashDailyId = cashDailyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cashSubId != null ? cashSubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashDailySub)) {
            return false;
        }
        CashDailySub other = (CashDailySub) object;
        if ((this.cashSubId == null && other.cashSubId != null) || (this.cashSubId != null && !this.cashSubId.equals(other.cashSubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.CashDailySub[ cashSubId=" + cashSubId + " ]";
    }

}
