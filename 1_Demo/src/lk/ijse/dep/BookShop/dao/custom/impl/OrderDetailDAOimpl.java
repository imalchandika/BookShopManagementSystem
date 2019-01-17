package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.OrderDetailDAO;
import lk.ijse.dep.BookShop.entity.OrderDetail;

import java.util.List;

public class OrderDetailDAOimpl implements OrderDetailDAO {
    @Override
    public OrderDetail find(String key) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(OrderDetail entity) throws Exception {
        return 0< CrudUtil.<Integer>execute("insert into orderdetail values(?,?,?,?)",entity.getoId(),
                entity.getbId(),entity.getQty(),entity.getUnitPrice());
    }

    @Override
    public boolean update(OrderDetail entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
