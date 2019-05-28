/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Route;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import query.RouteQuery;

/**
 *
 * @author Anna
 */
@Named(value = "routesBean")
@SessionScoped
public class RoutesBean implements Serializable {

     private int idRoute;
    
    @EJB
    private RouteQuery query = new RouteQuery();

    public RouteQuery getQuery() {
        return query;
    }

    public void setQuery(RouteQuery query) {
        this.query = query;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

   
    /** 
     * Creates a new instance of RoutesBean
     */
    public String show(){
            System.out.println(idRoute);
            Route route = query.getRoute(idRoute);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("idRoute", route.getIdRoute());
            context.getExternalContext().getSessionMap().put("currRoute", route);
            return "route.xhtml";
    }
    
    public List<Route> getAllRoutes(){
      return query.getAllRoutes();
    }
    
      public int name(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        return (Integer)context.getExternalContext().getSessionMap().get("idRoute");
    }
}
