package dao.oraclejpa;

import dao.service.EntityService;

import javax.persistence.EntityManager;

public abstract class OracleJpaDao<T> implements EntityService<T> {

    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public abstract T read(int id);

    public abstract void delete(int entityID);

//    public void refresh(T entity) {
//        em.getTransaction().begin();
//        em.refresh(entity);
//        em.getTransaction().commit();
//    }

    public void update(T entity) {
//        em.getTransaction().begin();
        em.merge(entity);
//        em.getTransaction().commit();
    }
}
