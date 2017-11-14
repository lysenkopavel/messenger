package dao.factory;

import dao.oraclejpa.OracleJpaDao;
import dao.oraclejpa.ChatOracleDAO;
import dao.oraclejpa.UserOracleDAO;
import dao.service.ChatService;
import dao.service.EntityService;
import dao.service.UserService;
import entities.Chat;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class OracleJpaDaoFactory extends DAOFactory {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("messenger").createEntityManager();

    public UserService getUserDAO() {
        UserOracleDAO userOracleDao = new UserOracleDAO();
        userOracleDao.setEm(entityManager);
        return userOracleDao;
    }

    public ChatService getChatDAO() {
        ChatOracleDAO chatOracleDao = new ChatOracleDAO();
        chatOracleDao.setEm(entityManager);
        return chatOracleDao;
    }

}
