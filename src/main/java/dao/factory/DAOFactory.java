package dao.factory;

import dao.oraclejpa.OracleJpaDao;
import dao.service.ChatService;
import dao.service.EntityService;
import dao.service.UserService;
import entities.*;

public abstract class DAOFactory {

    public static final int ORACLE_JPA = 1;

    public abstract UserService getUserDAO();
    public abstract ChatService getChatDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case ORACLE_JPA:
                return new OracleJpaDaoFactory();
            default:
                return new OracleJpaDaoFactory();
        }
    }

}
