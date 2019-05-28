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
import javax.ejb.EJB;
import query.RouteQuery;
import java.util.Date;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anna
 */
@Named(value = "addRouteBean")
@SessionScoped
public class AddRouteBean implements Serializable {

    private Route addRoute = new Route(); 
    private String date;

    @EJB
    private RouteQuery query = new RouteQuery();
    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public AddRouteBean() {
    }
    
    public String addRoute() throws ParseException{
        
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

    public Route getAddRoute() {
        return addRoute;
    }


    public void setAddRoute(Route addRoute) {
        this.addRoute = addRoute;
    }

    public RouteQuery getQuery() {
        return query;
    }


    public void setQuery(RouteQuery query) {
        this.query = query;
    }
    
}
