package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.OrderDAO;
import lk.ijse.dep.BookShop.entity.Orders;

import java.util.List;

public class OrderDAOimpl implements OrderDAO {

    @Override
    public Orders find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Orders entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("insert into OrderBook values(?,?,?)",entity.getOid(),entity.getDate(),entity.getCustomerid());
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
