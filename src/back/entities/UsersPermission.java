package back.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "USERS_PERMISSION")
@NamedQueries({
    @NamedQuery(name = "UsersPermission.findAll", query = "SELECT u FROM UsersPermission u"),
    @NamedQuery(name = "UsersPermission.findByPermissionId", query = "SELECT u FROM UsersPermission u WHERE u.permissionId = :permissionId"),
    @NamedQuery(name = "UsersPermission.findByFormEntryStatus", query = "SELECT u FROM UsersPermission u WHERE u.formEntryStatus = :formEntryStatus"),
    @NamedQuery(name = "UsersPermission.findByFormPrintStatus", query = "SELECT u FROM UsersPermission u WHERE u.formPrintStatus = :formPrintStatus"),
    @NamedQuery(name = "UsersPermission.findByFormMovmentStatus", query = "SELECT u FROM UsersPermission u WHERE u.formMovmentStatus = :formMovmentStatus"),
    @NamedQuery(name = "UsersPermission.findByFormUpdateStatus", query = "SELECT u FROM UsersPermission u WHERE u.formUpdateStatus = :formUpdateStatus")})
public class UsersPermission implements Serializable {

    private Integer permissionId;
    private Boolean formEntryStatus;
    private Boolean formPrintStatus;
    private Boolean formMovmentStatus;
    private Boolean formUpdateStatus;
    private Forms formId;
    private Users userId;

    public UsersPermission() {
    }

    public UsersPermission(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @TableGenerator(name = "UsersPermissionGen", table = "MAIN_SEQUENCE",
            pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
            pkColumnValue = "USERS_PERMISSION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "UsersPermissionGen")
    @Id
    @Column(name = "PERMISSION_ID")
    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Column(name = "FORM_ENTRY_STATUS")
    public Boolean getFormEntryStatus() {
        return formEntryStatus;
    }

    public void setFormEntryStatus(Boolean formEntryStatus) {
        this.formEntryStatus = formEntryStatus;
    }

    @Column(name = "FORM_PRINT_STATUS")
    public Boolean getFormPrintStatus() {
        return formPrintStatus;
    }

    public void setFormPrintStatus(Boolean formPrintStatus) {
        this.formPrintStatus = formPrintStatus;
    }

    @Column(name = "FORM_MOVMENT_STATUS")
    public Boolean getFormMovmentStatus() {
        return formMovmentStatus;
    }

    public void setFormMovmentStatus(Boolean formMovmentStatus) {
        this.formMovmentStatus = formMovmentStatus;
    }

    @Column(name = "FORM_UPDATE_STATUS")
    public Boolean getFormUpdateStatus() {
        return formUpdateStatus;
    }

    public void setFormUpdateStatus(Boolean formUpdateStatus) {
        this.formUpdateStatus = formUpdateStatus;
    }

    @JoinColumn(name = "FORM_ID", referencedColumnName = "FORM_ID")
    @ManyToOne(optional = false)
    public Forms getFormId() {
        return formId;
    }

    public void setFormId(Forms formId) {
        this.formId = formId;
    }

    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionId != null ? permissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPermission)) {
            return false;
        }
        UsersPermission other = (UsersPermission) object;
        if ((this.permissionId == null && other.permissionId != null) || (this.permissionId != null && !this.permissionId.equals(other.permissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.UsersPermission[ permissionId=" + permissionId + " ]";
    }

}
