package mydao.jpaservice;

import mydao.service.ChatService;
import mydao.service.EntityService;

import javax.persistence.EntityManager;

public abstract class OracleJpaDao<T> implements EntityService<T> {

    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public abstract T read(int entityID);

    public void delete(int entityID){
        T entity = read(entityID);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
}
