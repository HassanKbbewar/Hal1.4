package back.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "USER_INFORMATION")

public class UserInformation implements Serializable {

    private String userDetails1;
    private String userDetails2;
    private String userDetails3;
    private String userDetails4;
    private String userPhoneNumber1;
    private String userPhoneNumber2;
    private String userPhoneNumber3;
    private Short userDefaultCommsion;
    private Short userPercentageCount;
    private Short userDefaultMasrof;
    private Short userMasrofPercentage;
    private Short userTabrizPercentage;
    private Boolean userTabrizDailyPay;
    private Short userTabrizDefaultValue;
    private Boolean userCommissionCountToFivePound;
    private Short userInvoiceSize;
    private String cashierUserName1;
    private String cashierUserName2;
    private String cashierUserName3;
    private Boolean addSubjectsStatus;
    private Boolean userDefaultPaidInvoice;
    private Boolean userCountWatching;

    public UserInformation() {
    }

    public UserInformation(String userDetails1) {
        this.userDetails1 = userDetails1;
    }

    @Id
    @Column(name = "USER_DETAILS1")
    public String getUserDetails1() {
        return userDetails1;
    }

    public void setUserDetails1(String userDetails1) {
        this.userDetails1 = userDetails1;
    }

    @Column(name = "USER_DETAILS2")
    public String getUserDetails2() {
        return userDetails2;
    }

    public void setUserDetails2(String userDetails2) {
        this.userDetails2 = userDetails2;
    }

    @Column(name = "USER_DETAILS3")
    public String getUserDetails3() {
        return userDetails3;
    }

    public void setUserDetails3(String userDetails3) {
        this.userDetails3 = userDetails3;
    }

    @Column(name = "USER_DETAILS4")
    public String getUserDetails4() {
        return userDetails4;
    }

    public void setUserDetails4(String userDetails4) {
        this.userDetails4 = userDetails4;
    }

    @Column(name = "USER_PHONE_NUMBER1")
    public String getUserPhoneNumber1() {
        return userPhoneNumber1;
    }

    public void setUserPhoneNumber1(String userPhoneNumber1) {
        this.userPhoneNumber1 = userPhoneNumber1;
    }

    @Column(name = "USER_PHONE_NUMBER2")
    public String getUserPhoneNumber2() {
        return userPhoneNumber2;
    }

    public void setUserPhoneNumber2(String userPhoneNumber2) {
        this.userPhoneNumber2 = userPhoneNumber2;
    }

    @Column(name = "USER_PHONE_NUMBER3")
    public String getUserPhoneNumber3() {
        return userPhoneNumber3;
    }

    public void setUserPhoneNumber3(String userPhoneNumber3) {
        this.userPhoneNumber3 = userPhoneNumber3;
    }

    @Column(name = "USER_DEFAULT_COMMSION")
    public Short getUserDefaultCommsion() {
        return userDefaultCommsion;
    }

    public void setUserDefaultCommsion(Short userDefaultCommsion) {
        this.userDefaultCommsion = userDefaultCommsion;
    }

    @Column(name = "USER_PERCENTAGE_COUNT")
    public Short getUserPercentageCount() {
        return userPercentageCount;
    }

    public void setUserPercentageCount(Short userPercentageCount) {
        this.userPercentageCount = userPercentageCount;
    }

    @Column(name = "USER_DEFAULT_MASROF")
    public Short getUserDefaultMasrof() {
        return userDefaultMasrof;
    }

    public void setUserDefaultMasrof(Short userDefaultMasrof) {
        this.userDefaultMasrof = userDefaultMasrof;
    }

    @Column(name = "USER_MASROF_PERCENTAGE")
    public Short getUserMasrofPercentage() {
        return userMasrofPercentage;
    }

    public void setUserMasrofPercentage(Short userMasrofPercentage) {
        this.userMasrofPercentage = userMasrofPercentage;
    }

    @Column(name = "USER_TABRIZ_PERCENTAGE")
    public Short getUserTabrizPercentage() {
        return userTabrizPercentage;
    }

    public void setUserTabrizPercentage(Short userTabrizPercentage) {
        this.userTabrizPercentage = userTabrizPercentage;
    }

    @Column(name = "USER_TABRIZ_DAILY_PAY")
    public Boolean getUserTabrizDailyPay() {
        return userTabrizDailyPay;
    }

    public void setUserTabrizDailyPay(Boolean userTabrizDailyPay) {
        this.userTabrizDailyPay = userTabrizDailyPay;
    }

    @Column(name = "USER_TABRIZ_DEFAULT_VALUE")
    public Short getUserTabrizDefaultValue() {
        return userTabrizDefaultValue;
    }

    public void setUserTabrizDefaultValue(Short userTabrizDefaultValue) {
        this.userTabrizDefaultValue = userTabrizDefaultValue;
    }

    @Column(name = "USER_COMMISSION_COUNT_TO_FIVE_POUND")
    public Boolean getUserCommissionCountToFivePound() {
        return userCommissionCountToFivePound;
    }

    public void setUserCommissionCountToFivePound(Boolean userCommissionCountToFivePound) {
        this.userCommissionCountToFivePound = userCommissionCountToFivePound;
    }

    @Column(name = "USER_INVOICE_SIZE")
    public Short getUserInvoiceSize() {
        return userInvoiceSize;
    }

    public void setUserInvoiceSize(Short userInvoiceSize) {
        this.userInvoiceSize = userInvoiceSize;
    }

    @Column(name = "CASHIER_USER_NAME1")
    public String getCashierUserName1() {
        return cashierUserName1;
    }

    public void setCashierUserName1(String cashierUserName1) {
        this.cashierUserName1 = cashierUserName1;
    }

    @Column(name = "CASHIER_USER_NAME2")
    public String getCashierUserName2() {
        return cashierUserName2;
    }

    public void setCashierUserName2(String cashierUserName2) {
        this.cashierUserName2 = cashierUserName2;
    }

    @Column(name = "CASHIER_USER_NAME3")
    public String getCashierUserName3() {
        return cashierUserName3;
    }

    public void setCashierUserName3(String cashierUserName3) {
        this.cashierUserName3 = cashierUserName3;
    }

    @Column(name = "ADD_SUBJECTS_STATUS")
    public Boolean getAddSubjectsStatus() {
        return addSubjectsStatus;
    }

    public void setAddSubjectsStatus(Boolean addSubjectsStatus) {
        this.addSubjectsStatus = addSubjectsStatus;
    }

    @Column(name = "USER_DEFAULT_PAID_INVOICE")
    public Boolean getUserDefaultPaidInvoice() {
        return userDefaultPaidInvoice;
    }

    public void setUserDefaultPaidInvoice(Boolean userDefaultPaidInvoice) {
        this.userDefaultPaidInvoice = userDefaultPaidInvoice;
    }

    @Column(name = "USER_COUNT_WATCHING")
    public Boolean getUserCountWatching() {
        return userCountWatching;
    }

    public void setUserCountWatching(Boolean userCountWatching) {
        this.userCountWatching = userCountWatching;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDetails1 != null ? userDetails1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInformation)) {
            return false;
        }
        UserInformation other = (UserInformation) object;
        if ((this.userDetails1 == null && other.userDetails1 != null) || (this.userDetails1 != null && !this.userDetails1.equals(other.userDetails1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.UserInformation[ userDetails1=" + userDetails1 + " ]";
    }

}
