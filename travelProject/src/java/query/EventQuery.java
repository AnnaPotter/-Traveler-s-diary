/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import entity.Event;
import entity.Route;
import entity.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anna
 */
@Stateless
@LocalBean
public class EventQuery {
    
    @PersistenceContext(unitName="travelProjectPU")
    private EntityManager em;
    
    public List<Event> getAllEvents(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        Route route = (Route)context.getExternalContext().getSessionMap().get("currRoute");
        return em.createNamedQuery("Event.findByIdRoute").setParameter("idRouteE",route).getResultList();
    }
}
