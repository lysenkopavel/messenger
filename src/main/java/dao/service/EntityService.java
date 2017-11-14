package dao.service;

public interface EntityService<T> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T read(int id);

}
