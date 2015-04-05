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
@Table(name = "INVOICE_DETAILS")
@NamedQueries({
    @NamedQuery(name = "InvoiceDetails.findAll", query = "SELECT i FROM InvoiceDetails i"),
    @NamedQuery(name = "InvoiceDetails.findByInvoiceDetailsId", query = "SELECT i FROM InvoiceDetails i WHERE i.invoiceDetailsId = :invoiceDetailsId"),
    @NamedQuery(name = "InvoiceDetails.findByKind", query = "SELECT i FROM InvoiceDetails i WHERE i.kind = :kind"),
    @NamedQuery(name = "InvoiceDetails.findByBoxNumber", query = "SELECT i FROM InvoiceDetails i WHERE i.boxNumber = :boxNumber"),
    @NamedQuery(name = "InvoiceDetails.findByWeight", query = "SELECT i FROM InvoiceDetails i WHERE i.weight = :weight"),
    @NamedQuery(name = "InvoiceDetails.findByPrice", query = "SELECT i FROM InvoiceDetails i WHERE i.price = :price"),
    @NamedQuery(name = "InvoiceDetails.findBySaleType", query = "SELECT i FROM InvoiceDetails i WHERE i.saleType = :saleType")})
public class InvoiceDetails implements Serializable {

    private Integer invoiceDetailsId;
    private String kind;
    private Integer boxNumber;
    private Integer weight;
    private Integer price;
    private String saleType;
    private Invoices invoiceId;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Integer invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
    }

    @TableGenerator(name = "InvoiceDetailsGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "INVOICE_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "InvoiceDetailsGen")
    @Id
    @Column(name = "INVOICE_DETAILS_ID")
    public Integer getInvoiceDetailsId() {
        return invoiceDetailsId;
    }

    public void setInvoiceDetailsId(Integer invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
    }

    @Column(name = "KIND")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Invoices getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoices invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceDetailsId != null ? invoiceDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDetails)) {
            return false;
        }
        InvoiceDetails other = (InvoiceDetails) object;
        if ((this.invoiceDetailsId == null && other.invoiceDetailsId != null) || (this.invoiceDetailsId != null && !this.invoiceDetailsId.equals(other.invoiceDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.InvoiceDetails[ invoiceDetailsId=" + invoiceDetailsId + " ]";
    }

}
