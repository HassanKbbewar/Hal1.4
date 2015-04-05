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
@Table(name = "CARGO")
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCargoId", query = "SELECT c FROM Cargo c WHERE c.cargoId = :cargoId"),
    @NamedQuery(name = "Cargo.findByCargoCommision", query = "SELECT c FROM Cargo c WHERE c.cargoCommision = :cargoCommision"),
    @NamedQuery(name = "Cargo.findByCargoPaid", query = "SELECT c FROM Cargo c WHERE c.cargoPaid = :cargoPaid"),
    @NamedQuery(name = "Cargo.findByCargoMashal", query = "SELECT c FROM Cargo c WHERE c.cargoMashal = :cargoMashal"),
    @NamedQuery(name = "Cargo.findByCargoDeposit", query = "SELECT c FROM Cargo c WHERE c.cargoDeposit = :cargoDeposit"),
    @NamedQuery(name = "Cargo.findByCargoDate", query = "SELECT c FROM Cargo c WHERE c.cargoDate = :cargoDate"),
    @NamedQuery(name = "Cargo.findByCargoStatus", query = "SELECT c FROM Cargo c WHERE c.cargoStatus = :cargoStatus"),
    @NamedQuery(name = "Cargo.findByCargoNote", query = "SELECT c FROM Cargo c WHERE c.cargoNote = :cargoNote"),
    @NamedQuery(name = "Cargo.findByCargoReturnValue", query = "SELECT c FROM Cargo c WHERE c.cargoReturnValue = :cargoReturnValue"),
    @NamedQuery(name = "Cargo.findByCargoReturnDate", query = "SELECT c FROM Cargo c WHERE c.cargoReturnDate = :cargoReturnDate")})
public class Cargo implements Serializable {

    private Integer cargoId;
    private Integer cargoCommision;
    private Integer cargoPaid;
    private Integer cargoMashal;
    private Integer cargoDeposit;
    private Date cargoDate;
    private Boolean cargoStatus;
    private String cargoNote;
    private Integer cargoReturnValue;
    private Date cargoReturnDate;
    private List<CargoDetails> cargoDetailsList;
    private Account accountId;
    private Daily dailyId;

    public Cargo() {
    }

    public Cargo(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @TableGenerator(name = "CargoGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "CARGO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "CargoGen")
    @Id
    @Column(name = "CARGO_ID")
    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Column(name = "CARGO_COMMISION")
    public Integer getCargoCommision() {
        return cargoCommision;
    }

    public void setCargoCommision(Integer cargoCommision) {
        this.cargoCommision = cargoCommision;
    }

    @Column(name = "CARGO_PAID")
    public Integer getCargoPaid() {
        return cargoPaid;
    }

    public void setCargoPaid(Integer cargoPaid) {
        this.cargoPaid = cargoPaid;
    }

    @Column(name = "CARGO_MASHAL")
    public Integer getCargoMashal() {
        return cargoMashal;
    }

    public void setCargoMashal(Integer cargoMashal) {
        this.cargoMashal = cargoMashal;
    }

    @Column(name = "CARGO_DEPOSIT")
    public Integer getCargoDeposit() {
        return cargoDeposit;
    }

    public void setCargoDeposit(Integer cargoDeposit) {
        this.cargoDeposit = cargoDeposit;
    }

    @Column(name = "CARGO_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCargoDate() {
        return cargoDate;
    }

    public void setCargoDate(Date cargoDate) {
        this.cargoDate = cargoDate;
    }

    @Column(name = "CARGO_STATUS")
    public Boolean getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(Boolean cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    @Column(name = "CARGO_NOTE")
    public String getCargoNote() {
        return cargoNote;
    }

    public void setCargoNote(String cargoNote) {
        this.cargoNote = cargoNote;
    }

    @Column(name = "CARGO_RETURN_VALUE")
    public Integer getCargoReturnValue() {
        return cargoReturnValue;
    }

    public void setCargoReturnValue(Integer cargoReturnValue) {
        this.cargoReturnValue = cargoReturnValue;
    }

    @Column(name = "CARGO_RETURN_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCargoReturnDate() {
        return cargoReturnDate;
    }

    public void setCargoReturnDate(Date cargoReturnDate) {
        this.cargoReturnDate = cargoReturnDate;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoId")
    public List<CargoDetails> getCargoDetailsList() {
        return cargoDetailsList;
    }

    public void setCargoDetailsList(List<CargoDetails> cargoDetailsList) {
        this.cargoDetailsList = cargoDetailsList;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @JoinColumn(name = "DAILY_ID", referencedColumnName = "DAILY_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Daily getDailyId() {
        return dailyId;
    }

    public void setDailyId(Daily dailyId) {
        this.dailyId = dailyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoId != null ? cargoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargoId == null && other.cargoId != null) || (this.cargoId != null && !this.cargoId.equals(other.cargoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Cargo[ cargoId=" + cargoId + " ]";
    }

}
