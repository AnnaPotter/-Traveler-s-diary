/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Anna
 */
@Stateless
@LocalBean
public class UserQuery {
   
    //private EntityManagerFactory emf;
    @PersistenceContext(unitName="travelProjectPU")
    private EntityManager em;

    
//    public UserQuery() {
//        System.out.println("1");
//        emf = Persistence.createEntityManagerFactory("travelProjectPU");
//        System.out.println("2");
//        em = emf.createEntityManager();
//        System.out.println("3");
//        em.getTransaction().begin();
//    }
    
    public boolean loginControl(String username, String password){
        try {
            System.out.println("4");
            //
            List<User> list = em.createNamedQuery("User.loginControl", User.class).setParameter("userName", username).setParameter("password",password).getResultList();
            System.out.println("5");
            if(list.isEmpty()) return false;
            else 
            if (list.get(0)!=null && list.size()==1){
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            System.out.println("TuTuTu");
            System.out.println(e);
            return false;
        }
}
}
