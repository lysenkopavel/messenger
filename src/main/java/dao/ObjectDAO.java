package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class ObjectDAO<T> {

    final static EntityManager em = Persistence.createEntityManagerFactory("messenger").createEntityManager();

    public static void beginTransaction() {
        em.getTransaction().begin();
    }

    public static void commitTransaction() {
        em.getTransaction().commit();
    }

    public void create(T entity) {
        em.persist(entity);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public abstract T read(int id);

    public abstract void delete(T entity);

    public abstract void showAll();

}
