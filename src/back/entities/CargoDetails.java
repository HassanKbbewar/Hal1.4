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
@Table(name = "CARGO_DETAILS")
@NamedQueries({
    @NamedQuery(name = "CargoDetails.findAll", query = "SELECT c FROM CargoDetails c"),
    @NamedQuery(name = "CargoDetails.findByDetailId", query = "SELECT c FROM CargoDetails c WHERE c.detailId = :detailId"),
    @NamedQuery(name = "CargoDetails.findByKindName", query = "SELECT c FROM CargoDetails c WHERE c.kindName = :kindName"),
    @NamedQuery(name = "CargoDetails.findByBoxNumber", query = "SELECT c FROM CargoDetails c WHERE c.boxNumber = :boxNumber"),
    @NamedQuery(name = "CargoDetails.findByWeight", query = "SELECT c FROM CargoDetails c WHERE c.weight = :weight"),
    @NamedQuery(name = "CargoDetails.findByPrice", query = "SELECT c FROM CargoDetails c WHERE c.price = :price"),
    @NamedQuery(name = "CargoDetails.findByMasrof", query = "SELECT c FROM CargoDetails c WHERE c.masrof = :masrof"),
    @NamedQuery(name = "CargoDetails.findByMasrofCash", query = "SELECT c FROM CargoDetails c WHERE c.masrofCash = :masrofCash"),
    @NamedQuery(name = "CargoDetails.findBySaleType", query = "SELECT c FROM CargoDetails c WHERE c.saleType = :saleType")})
public class CargoDetails implements Serializable {

    private Integer detailId;
    private String kindName;
    private Integer boxNumber;
    private Integer weight;
    private Integer price;
    private Integer masrof;
    private Integer masrofCash;
    private String saleType;
    private Account accountId;
    private Cargo cargoId;

    public CargoDetails() {
    }

    public CargoDetails(Integer detailId) {
        this.detailId = detailId;
    }

    @TableGenerator(name = "CargoDetailsGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "CARGO_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "CargoDetailsGen")
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

    @Column(name = "SALE_TYPE")
    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @JoinColumn(name = "CARGO_ID", referencedColumnName = "CARGO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
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
        if (!(object instanceof CargoDetails)) {
            return false;
        }
        CargoDetails other = (CargoDetails) object;
        if ((this.detailId == null && other.detailId != null) || (this.detailId != null && !this.detailId.equals(other.detailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.CargoDetails[ detailId=" + detailId + " ]";
    }

}
