package dao.service;

public interface EntityService<T> {

    void delete(int entityID);

    T read(int entityID);

    void update(T entity);

//    void refresh(T entity);
}
