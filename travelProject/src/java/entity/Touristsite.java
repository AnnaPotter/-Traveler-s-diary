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
@Table(name = "touristsite")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Touristsite.findByIdRoute", query = "SELECT t FROM Touristsite t WHERE t.idRouteTS = :idRouteTS")
    , @NamedQuery(name = "Touristsite.findAll", query = "SELECT t FROM Touristsite t")
    , @NamedQuery(name = "Touristsite.findByIdTouristSite", query = "SELECT t FROM Touristsite t WHERE t.idTouristSite = :idTouristSite")
    , @NamedQuery(name = "Touristsite.findByTitle", query = "SELECT t FROM Touristsite t WHERE t.title = :title")
    , @NamedQuery(name = "Touristsite.findByLocation", query = "SELECT t FROM Touristsite t WHERE t.location = :location")
    , @NamedQuery(name = "Touristsite.findByDescription", query = "SELECT t FROM Touristsite t WHERE t.description = :description")})
public class Touristsite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTouristSite")
    private Integer idTouristSite;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @Size(max = 5000)
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @JoinColumn(name = "idRouteTS", referencedColumnName = "idRoute")
    @ManyToOne(optional = false)
    private Route idRouteTS;

    public Touristsite() {
    }

    public Touristsite(Integer idTouristSite) {
        this.idTouristSite = idTouristSite;
    }

    public Integer getIdTouristSite() {
        return idTouristSite;
    }

    public void setIdTouristSite(Integer idTouristSite) {
        this.idTouristSite = idTouristSite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Route getIdRouteTS() {
        return idRouteTS;
    }

    public void setIdRouteTS(Route idRouteTS) {
        this.idRouteTS = idRouteTS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTouristSite != null ? idTouristSite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Touristsite)) {
            return false;
        }
        Touristsite other = (Touristsite) object;
        if ((this.idTouristSite == null && other.idTouristSite != null) || (this.idTouristSite != null && !this.idTouristSite.equals(other.idTouristSite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Touristsite[ idTouristSite=" + idTouristSite + " ]";
    }
    
}
