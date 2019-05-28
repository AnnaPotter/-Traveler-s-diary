/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Event;
import entity.Populatedlocality;
import entity.Touristsite;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import query.EventQuery;
import query.LocalityQuery;

import query.SightQuery;

/**
 *
 * @author Anna
 */
@Named(value = "viewRouteBeen")
@SessionScoped
public class ViewRouteBeen implements Serializable {

    private int idEvent;
    private int idLocation;
    private int idSite;
    
     @EJB
    private EventQuery queryEvent = new EventQuery();
     @EJB
    private SightQuery querySight= new SightQuery();
     @EJB
    private LocalityQuery queryLocality = new LocalityQuery();
    
    public List<Event> getAllEvents(){
      return queryEvent.getAllEvents();
    }
    
    public List<Touristsite> getAllSights(){
      return querySight.getAllSights();
    }
    
     public List<Populatedlocality> getAllLocalities(){
      return queryLocality.getAllLocalities();
    }
    
    
     
    
    public EventQuery getQueryEvent() {
        return queryEvent;
    }

    public void setQueryEvent(EventQuery queryEvent) {
        this.queryEvent = queryEvent;
    }

    public SightQuery getQuerySight() {
        return querySight;
    }

    public void setQuerySight(SightQuery querySight) {
        this.querySight = querySight;
    }
     
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }    
     
    public ViewRouteBeen() {
    }
    
}
