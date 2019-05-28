/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

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
public class RouteQuery {
    
    @PersistenceContext(unitName="travelProjectPU")
    private EntityManager em;
    
    public List<Route> getAllRoutes(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        User user = (User)context.getExternalContext().getSessionMap().get("currUser");
        return em.createNamedQuery("Route.findByIdUser").setParameter("idUser",user).getResultList();
    }
    
   // public List<Route> getHikes(){
    //    FacesContext context = FacesContext.getCurrentInstance(); 
     //   return em.createNamedQuery("Route.findByIdUser").setParameter("idUser",context.getExternalContext().getSessionMap().get("idUser")).setParameter("type", "hike").getResultList();
   // }

    public Route getRoute(int idRoute) {
        return em.find(Route.class, idRoute);
    }
    
    public boolean createRoute(Route r){
        if(r!=null) 
        {em.persist(r);
        return true;}
        else return false;
    }
}
