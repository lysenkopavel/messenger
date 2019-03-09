package mydao.jpaservice;

import mydao.service.*;
import entities.*;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class UserOracleDAO extends OracleJpaDao<User> implements UserService {

    public int create(String nickname) {
        User user = new User(nickname);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user.getUserID();
    }

    public User read(int id) {
        em.getTransaction().begin();
        User u = em.find(User.class, id);
        em.getTransaction().commit();
        return u;
    }

    public List<User> showAllUsers() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from USERS", User.class);
        List<User> resultList = query.getResultList();
//        System.out.println("Listing Users:");
//        if (!resultList.isEmpty()) {
//            for (User u : resultList) {
//                System.out.println(u.toString());
//            }
//        }
        em.getTransaction().commit();
        return resultList;
    }

    public Set<Chat> showUserChats(int uID) {
        User user = read(uID);
        return user.getUserChats();
    }



}
