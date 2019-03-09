package mydao.service;

public interface EntityService<T> {

    T read(int entityID);

    void update(T entity);

    void delete(int entityID);

}
