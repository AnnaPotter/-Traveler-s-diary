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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.*;
import query.RouteQuery;

/**
 *
 * @author Anna
 */
@Named(value = "routesBean")
@SessionScoped
public class RoutesBean implements Serializable {

    private int idRoute;
    private Route addRoute = new Route(); 
    private String date;
    
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

        public Route getAddRoute() {
        return addRoute;
    }

    public void setAddRoute(Route addRoute) {
        this.addRoute = addRoute;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
     public String addRoute() throws ParseException{
        if(addRoute.getNote().equals("") || addRoute.getType().equals("")) {
         RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Required fields are not filled!"));
        return "";
        } else {
        if(!date.equals("")){
        Date dateNew=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
        addRoute.setStartData(dateNew);
        }
        FacesContext context = FacesContext.getCurrentInstance(); 
        User user = (User)context.getExternalContext().getSessionMap().get("currUser");
        addRoute.setIdUser(user);
        
        if(query.createRoute(addRoute)) {
           return "routesPage.xhtml";
        }
        else return "";
        }
    }
   
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
    

     public String deleteRoute() {
       FacesContext context = FacesContext.getCurrentInstance(); 
       Route route = (Route)context.getExternalContext().getSessionMap().get("currRoute");
       query.removeRoute(route);
       return "routesPage?faces-redirect=true";
    }

}
