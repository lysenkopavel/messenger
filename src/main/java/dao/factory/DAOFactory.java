package dao.factory;

import dao.service.ChatService;
import dao.service.MessageService;
import dao.service.UserService;

public abstract class DAOFactory {

    public static final int ORACLE_JPA = 1;

    public abstract UserService getUserDAO();
    public abstract ChatService getChatDAO();
    public abstract MessageService getMessageService();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case ORACLE_JPA:
                return new OracleJpaDaoFactory();
            default:
                return new OracleJpaDaoFactory();
        }
    }

}
