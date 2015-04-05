package back.entities;

import java.io.Serializable;
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
@Table(name = "FORMS")
@NamedQueries({
    @NamedQuery(name = "Forms.findAll", query = "SELECT f FROM Forms f"),
    @NamedQuery(name = "Forms.findByFormId", query = "SELECT f FROM Forms f WHERE f.formId = :formId"),
    @NamedQuery(name = "Forms.findByFormName", query = "SELECT f FROM Forms f WHERE f.formName = :formName"),
    @NamedQuery(name = "Forms.findByFormBelongTo", query = "SELECT f FROM Forms f WHERE f.formBelongTo = :formBelongTo"),
    @NamedQuery(name = "Forms.findByFormDescription", query = "SELECT f FROM Forms f WHERE f.formDescription = :formDescription")})
public class Forms implements Serializable {

    private Integer formId;
    private String formName;
    private String formBelongTo;
    private String formDescription;

    public Forms() {
    }

    public Forms(Integer formId) {
        this.formId = formId;
    }

    @Id
    @Column(name = "FORM_ID")
    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    @Column(name = "FORM_NAME")
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Column(name = "FORM_BELONG_TO")
    public String getFormBelongTo() {
        return formBelongTo;
    }

    public void setFormBelongTo(String formBelongTo) {
        this.formBelongTo = formBelongTo;
    }

    @Column(name = "FORM_DESCRIPTION")
    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formId != null ? formId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forms)) {
            return false;
        }
        Forms other = (Forms) object;
        if ((this.formId == null && other.formId != null) || (this.formId != null && !this.formId.equals(other.formId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.entities.Forms[ formId=" + formId + " ]";
    }

}
