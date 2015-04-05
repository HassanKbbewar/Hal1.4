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
@Table(name = "INVOICES")
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByInvoiceId", query = "SELECT i FROM Invoices i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoices.findByWholePeiceCount", query = "SELECT i FROM Invoices i WHERE i.wholePeiceCount = :wholePeiceCount"),
    @NamedQuery(name = "Invoices.findBySaledPeiceCount", query = "SELECT i FROM Invoices i WHERE i.saledPeiceCount = :saledPeiceCount"),
    @NamedQuery(name = "Invoices.findByCommissionPercentage", query = "SELECT i FROM Invoices i WHERE i.commissionPercentage = :commissionPercentage"),
    @NamedQuery(name = "Invoices.findByPaidInHand", query = "SELECT i FROM Invoices i WHERE i.paidInHand = :paidInHand"),
    @NamedQuery(name = "Invoices.findByCarTransit", query = "SELECT i FROM Invoices i WHERE i.carTransit = :carTransit"),
    @NamedQuery(name = "Invoices.findByTabrizPercentage", query = "SELECT i FROM Invoices i WHERE i.tabrizPercentage = :tabrizPercentage"),
    @NamedQuery(name = "Invoices.findByOtherPaid", query = "SELECT i FROM Invoices i WHERE i.otherPaid = :otherPaid"),
    @NamedQuery(name = "Invoices.findByNote", query = "SELECT i FROM Invoices i WHERE i.note = :note"),
    @NamedQuery(name = "Invoices.findByInterchangePersonStatus", query = "SELECT i FROM Invoices i WHERE i.interchangePersonStatus = :interchangePersonStatus"),
    @NamedQuery(name = "Invoices.findByInterchangePercentage", query = "SELECT i FROM Invoices i WHERE i.interchangePercentage = :interchangePercentage"),
    @NamedQuery(name = "Invoices.findByCommession", query = "SELECT i FROM Invoices i WHERE i.commession = :commession"),
    @NamedQuery(name = "Invoices.findByTabriz", query = "SELECT i FROM Invoices i WHERE i.tabriz = :tabriz"),
    @NamedQuery(name = "Invoices.findByInvoiceValue", query = "SELECT i FROM Invoices i WHERE i.invoiceValue = :invoiceValue"),
    @NamedQuery(name = "Invoices.findByInvoiceFinalValue", query = "SELECT i FROM Invoices i WHERE i.invoiceFinalValue = :invoiceFinalValue"),
    @NamedQuery(name = "Invoices.findByInvoiceCashStatus", query = "SELECT i FROM Invoices i WHERE i.invoiceCashStatus = :invoiceCashStatus"),
    @NamedQuery(name = "Invoices.findByInvoicePrintStatus", query = "SELECT i FROM Invoices i WHERE i.invoicePrintStatus = :invoicePrintStatus"),
    @NamedQuery(name = "Invoices.findByInvoicePrintDate", query = "SELECT i FROM Invoices i WHERE i.invoicePrintDate = :invoicePrintDate")})
public class Invoices implements Serializable {

    private Integer invoiceId;
    private Integer wholePeiceCount;
    private Integer saledPeiceCount;
    private Short commissionPercentage;
    private Integer paidInHand;
    private Integer carTransit;
    private Integer tabrizPercentage;
    private Integer otherPaid;
    private String note;
    private Boolean interchangePersonStatus;
    private Short interchangePercentage;
    private Integer commession;
    private Integer tabriz;
    private Integer invoiceValue;
    private Integer invoiceFinalValue;
    private Boolean invoiceCashStatus;
    private Boolean invoicePrintStatus;
    private Date invoicePrintDate;
    private List<InvoiceDetails> invoiceDetailsList;
    private Account accountId;
    private Account interchangeAccountId;
    private Account privateCommissionId;
    private Account privateMashalAccountId;
    private CommissionSales commissionSalesId;
    private MergedInvoices mergeId;

    public Invoices() {
    }

    public Invoices(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @TableGenerator(name = "InvoicesGen", table = "SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "INVOICES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "InvoicesGen")
    @Id
    @Column(name = "INVOICE_ID")
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Column(name = "WHOLE_PEICE_COUNT")
    public Integer getWholePeiceCount() {
        return wholePeiceCount;
    }

    public void setWholePeiceCount(Integer wholePeiceCount) {
        this.wholePeiceCount = wholePeiceCount;
    }

    @Column(name = "SALED_PEICE_COUNT")
    public Integer getSaledPeiceCount() {
        return saledPeiceCount;
    }

    public void setSaledPeiceCount(Integer saledPeiceCount) {
        this.saledPeiceCount = saledPeiceCount;
    }

    @Column(name = "COMMISSION_PERCENTAGE")
    public Short getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Short commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    @Column(name = "PAID_IN_HAND")
    public Integer getPaidInHand() {
        return paidInHand;
    }

    public void setPaidInHand(Integer paidInHand) {
        this.paidInHand = paidInHand;
    }

    @Column(name = "CAR_TRANSIT")
    public Integer getCarTransit() {
        return carTransit;
    }

    public void setCarTransit(Integer carTransit) {
        this.carTransit = carTransit;
    }

    @Column(name = "TABRIZ_PERCENTAGE")
    public Integer getTabrizPercentage() {
        return tabrizPercentage;
    }

    public void setTabrizPercentage(Integer tabrizPercentage) {
        this.tabrizPercentage = tabrizPercentage;
    }

    @Column(name = "OTHER_PAID")
    public Integer getOtherPaid() {
        return otherPaid;
    }

    public void setOtherPaid(Integer otherPaid) {
        this.otherPaid = otherPaid;
    }

    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "INTERCHANGE_PERSON_STATUS")
    public Boolean getInterchangePersonStatus() {
        return interchangePersonStatus;
    }

    public void setInterchangePersonStatus(Boolean interchangePersonStatus) {
        this.interchangePersonStatus = interchangePersonStatus;
    }

    @Column(name = "INTERCHANGE_PERCENTAGE")
    public Short getInterchangePercentage() {
        return interchangePercentage;
    }

    public void setInterchangePercentage(Short interchangePercentage) {
        this.interchangePercentage = interchangePercentage;
    }

    @Column(name = "COMMESSION")
    public Integer getCommession() {
        return commession;
    }

    public void setCommession(Integer commession) {
        this.commession = commession;
    }

    @Column(name = "TABRIZ")
    public Integer getTabriz() {
        return tabriz;
    }

    public void setTabriz(Integer tabriz) {
        this.tabriz = tabriz;
    }

    @Column(name = "INVOICE_VALUE")
    public Integer getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Integer invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    @Column(name = "INVOICE_FINAL_VALUE")
    public Integer getInvoiceFinalValue() {
        return invoiceFinalValue;
    }

    public void setInvoiceFinalValue(Integer invoiceFinalValue) {
        this.invoiceFinalValue = invoiceFinalValue;
    }

    @Column(name = "INVOICE_CASH_STATUS")
    public Boolean getInvoiceCashStatus() {
        return invoiceCashStatus;
    }

    public void setInvoiceCashStatus(Boolean invoiceCashStatus) {
        this.invoiceCashStatus = invoiceCashStatus;
    }

    @Column(name = "INVOICE_PRINT_STATUS")
    public Boolean getInvoicePrintStatus() {
        return invoicePrintStatus;
    }

    public void setInvoicePrintStatus(Boolean invoicePrintStatus) {
        this.invoicePrintStatus = invoicePrintStatus;
    }

    @Column(name = "INVOICE_PRINT_DATE")
    @Temporal(TemporalType.DATE)
    public Date getInvoicePrintDate() {
        return invoicePrintDate;
    }

    public void setInvoicePrintDate(Date invoicePrintDate) {
        this.invoicePrintDate = invoicePrintDate;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceId", fetch = FetchType.LAZY)
    public List<InvoiceDetails> getInvoiceDetailsList() {
        return invoiceDetailsList;
    }

    public void setInvoiceDetailsList(List<InvoiceDetails> invoiceDetailsList) {
        this.invoiceDetailsList = invoiceDetailsList;
    }

    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @JoinColumn(name = "INTERCHANGE_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public Account getInterchangeAccountId() {
        return interchangeAccountId;
    }

    public void setInterchangeAccountId(Account interchangeAccountId) {
        this.interchangeAccountId = interchangeAccountId;
    }

    @JoinColumn(name = "PRIVATE_COMMISSION_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public Account getPrivateCommissionId() {
        return privateCommissionId;
    }

    public void setPrivateCommissionId(Account privateCommissionId) {
        this.privateCommissionId = privateCommissionId;
    }

    @JoinColumn(name = "PRIVATE_MASHAL_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public Account getPrivateMashalAccountId() {
        return privateMashalAccountId;
    }

    public void setPrivateMashalAccountId(Account privateMashalAccountId) {
        this.privateMashalAccountId = privateMashalAccountId;
    }

    @JoinColumn(name = "COMMISSION_SALES_ID", referencedColumnName = "COMMISSION_SALES_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public CommissionSales getCommissionSalesId() {
        return commissionSalesId;
    }

    public void setCommissionSalesId(CommissionSales commissionSalesId) {
        this.commissionSalesId = commissionSalesId;
    }

    @JoinColumn(name = "MERGE_ID", referencedColumnName = "MERGE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public MergedInvoices getMergeId() {
        return mergeId;
    }

    public void setMergeId(MergedInvoices mergeId) {
        this.mergeId = mergeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Invoices[ invoiceId=" + invoiceId + " ]";
    }

}
