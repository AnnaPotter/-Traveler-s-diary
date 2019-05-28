/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anna
 */
@Entity
@Table(name = "populatedlocality")
@XmlRootElement
@NamedQueries({
         @NamedQuery(name = "Populatedlocality.findByIdRoute", query = "SELECT p FROM Populatedlocality p WHERE p.idRoutePL = :idRoutePL")
    , @NamedQuery(name = "Populatedlocality.findAll", query = "SELECT p FROM Populatedlocality p")
    , @NamedQuery(name = "Populatedlocality.findByIdPopulatedLocalitycol", query = "SELECT p FROM Populatedlocality p WHERE p.idPopulatedLocalitycol = :idPopulatedLocalitycol")
    , @NamedQuery(name = "Populatedlocality.findByTitle", query = "SELECT p FROM Populatedlocality p WHERE p.title = :title")
    , @NamedQuery(name = "Populatedlocality.findByType", query = "SELECT p FROM Populatedlocality p WHERE p.type = :type")
    , @NamedQuery(name = "Populatedlocality.findByLocation", query = "SELECT p FROM Populatedlocality p WHERE p.location = :location")
    , @NamedQuery(name = "Populatedlocality.findByDescription", query = "SELECT p FROM Populatedlocality p WHERE p.description = :description")})
public class Populatedlocality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPopulatedLocalitycol")
    private Integer idPopulatedLocalitycol;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 200)
    @Column(name = "location")
    private String location;
    @Size(max = 10000)
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @JoinColumn(name = "idRoutePL", referencedColumnName = "idRoute")
    @ManyToOne(optional = false)
    private Route idRoutePL;

    public Populatedlocality() {
    }

    public Populatedlocality(Integer idPopulatedLocalitycol) {
        this.idPopulatedLocalitycol = idPopulatedLocalitycol;
    }

    public Integer getIdPopulatedLocalitycol() {
        return idPopulatedLocalitycol;
    }

    public void setIdPopulatedLocalitycol(Integer idPopulatedLocalitycol) {
        this.idPopulatedLocalitycol = idPopulatedLocalitycol;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Route getIdRoutePL() {
        return idRoutePL;
    }

    public void setIdRoutePL(Route idRoutePL) {
        this.idRoutePL = idRoutePL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPopulatedLocalitycol != null ? idPopulatedLocalitycol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Populatedlocality)) {
            return false;
        }
        Populatedlocality other = (Populatedlocality) object;
        if ((this.idPopulatedLocalitycol == null && other.idPopulatedLocalitycol != null) || (this.idPopulatedLocalitycol != null && !this.idPopulatedLocalitycol.equals(other.idPopulatedLocalitycol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Populatedlocality[ idPopulatedLocalitycol=" + idPopulatedLocalitycol + " ]";
    }
    
}
