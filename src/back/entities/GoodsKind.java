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
@Table(name = "GOODS_KIND")
@NamedQueries({
    @NamedQuery(name = "GoodsKind.findAll", query = "SELECT g FROM GoodsKind g"),
    @NamedQuery(name = "GoodsKind.findByKindId", query = "SELECT g FROM GoodsKind g WHERE g.kindId = :kindId"),
    @NamedQuery(name = "GoodsKind.findByKindName", query = "SELECT g FROM GoodsKind g WHERE g.kindName = :kindName"),
    @NamedQuery(name = "GoodsKind.findByKindMasrofByKilo", query = "SELECT g FROM GoodsKind g WHERE g.kindMasrofByKilo = :kindMasrofByKilo"),
    @NamedQuery(name = "GoodsKind.findByKindMasrofByPiece", query = "SELECT g FROM GoodsKind g WHERE g.kindMasrofByPiece = :kindMasrofByPiece"),
    @NamedQuery(name = "GoodsKind.findByKindCommissionByKind", query = "SELECT g FROM GoodsKind g WHERE g.kindCommissionByKind = :kindCommissionByKind"),
    @NamedQuery(name = "GoodsKind.findByKindCommissionByPiecce", query = "SELECT g FROM GoodsKind g WHERE g.kindCommissionByPiecce = :kindCommissionByPiecce"),
    @NamedQuery(name = "GoodsKind.findByKindCommissionByKilo", query = "SELECT g FROM GoodsKind g WHERE g.kindCommissionByKilo = :kindCommissionByKilo"),
    @NamedQuery(name = "GoodsKind.findByKindTamwenValue", query = "SELECT g FROM GoodsKind g WHERE g.kindTamwenValue = :kindTamwenValue"),
    @NamedQuery(name = "GoodsKind.findByKindLowestValue", query = "SELECT g FROM GoodsKind g WHERE g.kindLowestValue = :kindLowestValue"),
    @NamedQuery(name = "GoodsKind.findByKindHeighstValue", query = "SELECT g FROM GoodsKind g WHERE g.kindHeighstValue = :kindHeighstValue"),
    @NamedQuery(name = "GoodsKind.findByKindTabrizValue", query = "SELECT g FROM GoodsKind g WHERE g.kindTabrizValue = :kindTabrizValue")})
public class GoodsKind implements Serializable {

    private Integer kindId;
    private String kindName;
    private Integer kindMasrofByKilo;
    private Integer kindMasrofByPiece;
    private Integer kindCommissionByKind;
    private Integer kindCommissionByPiecce;
    private Integer kindCommissionByKilo;
    private Integer kindTamwenValue;
    private Integer kindLowestValue;
    private Integer kindHeighstValue;
    private Integer kindTabrizValue;

    public GoodsKind() {
    }

    public GoodsKind(Integer kindId) {
        this.kindId = kindId;
    }

    @TableGenerator(name = "GoodsKindGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "GOODS_KIND_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "GoodsKindGen")
    @Id
    @Column(name = "KIND_ID")
    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    @Column(name = "KIND_NAME")
    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Column(name = "KIND_MASROF_BY_KILO")
    public Integer getKindMasrofByKilo() {
        return kindMasrofByKilo;
    }

    public void setKindMasrofByKilo(Integer kindMasrofByKilo) {
        this.kindMasrofByKilo = kindMasrofByKilo;
    }

    @Column(name = "KIND_MASROF_BY_PIECE")
    public Integer getKindMasrofByPiece() {
        return kindMasrofByPiece;
    }

    public void setKindMasrofByPiece(Integer kindMasrofByPiece) {
        this.kindMasrofByPiece = kindMasrofByPiece;
    }

    @Column(name = "KIND_COMMISSION_BY_KIND")
    public Integer getKindCommissionByKind() {
        return kindCommissionByKind;
    }

    public void setKindCommissionByKind(Integer kindCommissionByKind) {
        this.kindCommissionByKind = kindCommissionByKind;
    }

    @Column(name = "KIND_COMMISSION_BY_PIECCE")
    public Integer getKindCommissionByPiecce() {
        return kindCommissionByPiecce;
    }

    public void setKindCommissionByPiecce(Integer kindCommissionByPiecce) {
        this.kindCommissionByPiecce = kindCommissionByPiecce;
    }

    @Column(name = "KIND_COMMISSION_BY_KILO")
    public Integer getKindCommissionByKilo() {
        return kindCommissionByKilo;
    }

    public void setKindCommissionByKilo(Integer kindCommissionByKilo) {
        this.kindCommissionByKilo = kindCommissionByKilo;
    }

    @Column(name = "KIND_TAMWEN_VALUE")
    public Integer getKindTamwenValue() {
        return kindTamwenValue;
    }

    public void setKindTamwenValue(Integer kindTamwenValue) {
        this.kindTamwenValue = kindTamwenValue;
    }

    @Column(name = "KIND_LOWEST_VALUE")
    public Integer getKindLowestValue() {
        return kindLowestValue;
    }

    public void setKindLowestValue(Integer kindLowestValue) {
        this.kindLowestValue = kindLowestValue;
    }

    @Column(name = "KIND_HEIGHST_VALUE")
    public Integer getKindHeighstValue() {
        return kindHeighstValue;
    }

    public void setKindHeighstValue(Integer kindHeighstValue) {
        this.kindHeighstValue = kindHeighstValue;
    }

    @Column(name = "KIND_TABRIZ_VALUE")
    public Integer getKindTabrizValue() {
        return kindTabrizValue;
    }

    public void setKindTabrizValue(Integer kindTabrizValue) {
        this.kindTabrizValue = kindTabrizValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kindId != null ? kindId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoodsKind)) {
            return false;
        }
        GoodsKind other = (GoodsKind) object;
        if ((this.kindId == null && other.kindId != null) || (this.kindId != null && !this.kindId.equals(other.kindId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.GoodsKind[ kindId=" + kindId + " ]";
    }

}
