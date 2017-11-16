package dao.factory;

import dao.oraclejpa.*;
import dao.service.*;

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

    public MessageService getMessageService() {
        MessageOracleDao messageOracleDao = new MessageOracleDao();
        messageOracleDao.setEm(entityManager);
        return messageOracleDao;
    }

}
