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
@Table(name = "BUYING_DETAILS")
@NamedQueries({
    @NamedQuery(name = "BuyingDetails.findAll", query = "SELECT b FROM BuyingDetails b"),
    @NamedQuery(name = "BuyingDetails.findByDetailId", query = "SELECT b FROM BuyingDetails b WHERE b.detailId = :detailId"),
    @NamedQuery(name = "BuyingDetails.findByKindName", query = "SELECT b FROM BuyingDetails b WHERE b.kindName = :kindName"),
    @NamedQuery(name = "BuyingDetails.findByBoxNumber", query = "SELECT b FROM BuyingDetails b WHERE b.boxNumber = :boxNumber"),
    @NamedQuery(name = "BuyingDetails.findByWeight", query = "SELECT b FROM BuyingDetails b WHERE b.weight = :weight"),
    @NamedQuery(name = "BuyingDetails.findByPrice", query = "SELECT b FROM BuyingDetails b WHERE b.price = :price"),
    @NamedQuery(name = "BuyingDetails.findBySaleType", query = "SELECT b FROM BuyingDetails b WHERE b.saleType = :saleType"),
    @NamedQuery(name = "BuyingDetails.findByMasrof", query = "SELECT b FROM BuyingDetails b WHERE b.masrof = :masrof"),
    @NamedQuery(name = "BuyingDetails.findByMasrofCash", query = "SELECT b FROM BuyingDetails b WHERE b.masrofCash = :masrofCash")})
public class BuyingDetails implements Serializable {

    private Integer detailId;
    private String kindName;
    private Integer boxNumber;
    private Integer weight;
    private Integer price;
    private String saleType;
    private Integer masrof;
    private Integer masrofCash;
    private Account accountId;
    private BuyingGoods buyingId;

    public BuyingDetails() {
    }

    public BuyingDetails(Integer detailId) {
        this.detailId = detailId;
    }

    @TableGenerator(name = "BuyingDetailsGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "BUYING_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "BuyingDetailsGen")
    @Id
    @Column(name = "DETAIL_ID")
    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    @Column(name = "KIND_NAME")
    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Column(name = "BOX_NUMBER")
    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    @Column(name = "WEIGHT")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "SALE_TYPE")
    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    @Column(name = "MASROF")
    public Integer getMasrof() {
        return masrof;
    }

    public void setMasrof(Integer masrof) {
        this.masrof = masrof;
    }

    @Column(name = "MASROF_CASH")
    public Integer getMasrofCash() {
        return masrofCash;
    }

    public void setMasrofCash(Integer masrofCash) {
        this.masrofCash = masrofCash;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @JoinColumn(name = "BUYING_ID", referencedColumnName = "BUYING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public BuyingGoods getBuyingId() {
        return buyingId;
    }

    public void setBuyingId(BuyingGoods buyingId) {
        this.buyingId = buyingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailId != null ? detailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyingDetails)) {
            return false;
        }
        BuyingDetails other = (BuyingDetails) object;
        if ((this.detailId == null && other.detailId != null) || (this.detailId != null && !this.detailId.equals(other.detailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.BuyingDetails[ detailId=" + detailId + " ]";
    }

}
