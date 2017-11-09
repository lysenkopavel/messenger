package dao;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class UserOracleDAO extends ObjectDAO<User> {

    public User read(int id) {
        return em.find(User.class, id);
    }

    public void delete(User entity) {
        em.remove(read(entity.getUserID()));
    }

    public void showAll() {
        Query query = em.createNativeQuery("select * from USERS", User.class);
        List<User> resultList = query.getResultList();
        System.out.println("Listing Users:");
        for (User u : resultList) {
            System.out.println(u.toString());
        }
    }

}
