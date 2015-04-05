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
@Table(name = "BUYING_GOODS")
@NamedQueries({
    @NamedQuery(name = "BuyingGoods.findAll", query = "SELECT b FROM BuyingGoods b"),
    @NamedQuery(name = "BuyingGoods.findByBuyingId", query = "SELECT b FROM BuyingGoods b WHERE b.buyingId = :buyingId"),
    @NamedQuery(name = "BuyingGoods.findByBuyingDate", query = "SELECT b FROM BuyingGoods b WHERE b.buyingDate = :buyingDate"),
    @NamedQuery(name = "BuyingGoods.findByBuyingStatus", query = "SELECT b FROM BuyingGoods b WHERE b.buyingStatus = :buyingStatus")})
public class BuyingGoods implements Serializable {

    private Integer buyingId;
    private Date buyingDate;
    private Boolean buyingStatus;
    private List<BuyingDetails> buyingDetailsList;
    private Account accountId;
    private Daily dailyId;

    public BuyingGoods() {
    }

    public BuyingGoods(Integer buyingId) {
        this.buyingId = buyingId;
    }

    @TableGenerator(name = "BuyingGoodsGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "BUYING_GOODS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "BuyingGoodsGen")
    @Id
    @Column(name = "BUYING_ID")
    public Integer getBuyingId() {
        return buyingId;
    }

    public void setBuyingId(Integer buyingId) {
        this.buyingId = buyingId;
    }

    @Column(name = "BUYING_DATE")
    @Temporal(TemporalType.DATE)
    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    @Column(name = "BUYING_STATUS")
    public Boolean getBuyingStatus() {
        return buyingStatus;
    }

    public void setBuyingStatus(Boolean buyingStatus) {
        this.buyingStatus = buyingStatus;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyingId", fetch = FetchType.LAZY)
    public List<BuyingDetails> getBuyingDetailsList() {
        return buyingDetailsList;
    }

    public void setBuyingDetailsList(List<BuyingDetails> buyingDetailsList) {
        this.buyingDetailsList = buyingDetailsList;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Daily getDailyId() {
        return dailyId;
    }

    public void setDailyId(Daily dailyId) {
        this.dailyId = dailyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buyingId != null ? buyingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyingGoods)) {
            return false;
        }
        BuyingGoods other = (BuyingGoods) object;
        if ((this.buyingId == null && other.buyingId != null) || (this.buyingId != null && !this.buyingId.equals(other.buyingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.BuyingGoods[ buyingId=" + buyingId + " ]";
    }

}
