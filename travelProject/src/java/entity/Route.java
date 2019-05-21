/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Anna
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
    , @NamedQuery(name = "Route.findByIdRoute", query = "SELECT r FROM Route r WHERE r.idRoute = :idRoute")
    , @NamedQuery(name = "Route.findByStartData", query = "SELECT r FROM Route r WHERE r.startData = :startData")
    , @NamedQuery(name = "Route.findByDuration", query = "SELECT r FROM Route r WHERE r.duration = :duration")
    , @NamedQuery(name = "Route.findByNote", query = "SELECT r FROM Route r WHERE r.note = :note")
    , @NamedQuery(name = "Route.findByType", query = "SELECT r FROM Route r WHERE r.type = :type")
    , @NamedQuery(name = "Route.findBySubtype", query = "SELECT r FROM Route r WHERE r.subtype = :subtype")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRoute")
    private Integer idRoute;
    @Column(name = "startData")
    @Temporal(TemporalType.DATE)
    private Date startData;
    @Column(name = "duration")
    private Integer duration;
    @Size(max = 500)
    @Column(name = "note")
    private String note;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "subtype")
    private String subtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRouteTS")
    private Collection<Touristsite> touristsiteCollection;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRoutePL")
    private Collection<Populatedlocality> populatedlocalityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRouteE")
    private Collection<Event> eventCollection;

    public Route() {
    }

    public Route(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Date getStartData() {
        return startData;
    }

    public void setStartData(Date startData) {
        this.startData = startData;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @XmlTransient
    public Collection<Touristsite> getTouristsiteCollection() {
        return touristsiteCollection;
    }

    public void setTouristsiteCollection(Collection<Touristsite> touristsiteCollection) {
        this.touristsiteCollection = touristsiteCollection;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Collection<Populatedlocality> getPopulatedlocalityCollection() {
        return populatedlocalityCollection;
    }

    public void setPopulatedlocalityCollection(Collection<Populatedlocality> populatedlocalityCollection) {
        this.populatedlocalityCollection = populatedlocalityCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoute != null ? idRoute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.idRoute == null && other.idRoute != null) || (this.idRoute != null && !this.idRoute.equals(other.idRoute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Route[ idRoute=" + idRoute + " ]";
    }
    
}
