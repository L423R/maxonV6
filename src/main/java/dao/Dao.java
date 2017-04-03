package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public interface Dao<T> extends Serializable {
    T getById(T entity,int id);
    void saveOrUpdate(T entity);
    void delete(T entity);
    List<T> getList(String query);
}
