package lk.ijse.dep.BookShop.dao;

import lk.ijse.dep.BookShop.entity.SuperEntity;


import java.util.List;


public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {

    T find(ID key) throws Exception;

    List<T> findAll() throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID key) throws Exception;

}
