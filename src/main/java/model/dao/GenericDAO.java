package model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    void save(T entity);

    T findById(ID id);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();
}
