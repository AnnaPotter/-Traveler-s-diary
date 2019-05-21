/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import query.UserQuery;

/**
 *
 * @author Anna
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String userName;
    private String password;
    @EJB
    private UserQuery query = new UserQuery();

    public String loginControl(){
        if(query.loginControl(userName, password)){
            return "home.xhtml";
        }
        System.out.println("Wrong login or password");
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Username or password invalid!"));
        return "";
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
