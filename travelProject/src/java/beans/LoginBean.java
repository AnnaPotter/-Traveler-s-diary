/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import javax.faces.bean.ManagedProperty;
import query.UserQuery;

/**
 *
 * @author Anna
 */

@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean implements Serializable {

    private String userName;
    private String password;
    @EJB
    private UserQuery query = new UserQuery();

    public String loginControl(){
        System.out.println(userName+" "+password);
        if(query.loginControl(userName, password)){
            User user = query.getUserByNP(userName, password);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("idUser", user.getIdUser());
            context.getExternalContext().getSessionMap().put("currUser", user);
    
            return "home?faces-redirect=true";
        } else{
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Username or password invalid!"));
        return "";
        }
    }
    
    public int name(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        return (Integer)context.getExternalContext().getSessionMap().get("idUser");
    }
    
    public UserQuery getQuery() {
        return query;
    }

    public void setQuery(UserQuery query) {
        this.query = query;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
    public LoginBean() {
    }
    
}
