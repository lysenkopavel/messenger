package dao.oraclejpa;

import dao.service.EntityService;

import javax.persistence.EntityManager;

public abstract class OracleJpaDao<T> implements EntityService<T> {

    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public abstract T read(int id);

    public abstract void delete(T entity);

    public abstract void showAll();

}
