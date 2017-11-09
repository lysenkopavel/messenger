package dao;

import entities.*;

public abstract class DAOFactory {

    public static final int ORACLE = 1;

    public abstract ObjectDAO<User> getUserDAO();
    public abstract ObjectDAO<Chat> getChatDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case ORACLE:
                return new OracleDAOFactory();
            default:
                return new OracleDAOFactory();
        }
    }

}
