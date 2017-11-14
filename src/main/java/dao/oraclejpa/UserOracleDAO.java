package dao.oraclejpa;

import dao.service.UserService;
import entities.User;

import javax.persistence.Query;
import java.util.List;

public class UserOracleDAO extends OracleJpaDao<User> implements UserService{

    public User read(int id) {
        return em.find(User.class, id);
    }

    public void delete(User entity) {
        em.getTransaction().begin();
        em.remove(read(entity.getUserID()));
        em.getTransaction().commit();
    }

    public void updateObjectFromDB(User user) {
        em.refresh(user);
    }

    public void showAll() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from USERS", User.class);
        List<User> resultList = query.getResultList();
        System.out.println("Listing Users:");
        for (User u : resultList) {
            System.out.println(u.toString());
        }
        em.getTransaction().commit();
    }

}
