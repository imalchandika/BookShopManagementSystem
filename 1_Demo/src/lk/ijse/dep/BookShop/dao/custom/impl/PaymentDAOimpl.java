package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.PaymentDAO;
import lk.ijse.dep.BookShop.entity.Payment;

import java.util.List;

public class PaymentDAOimpl implements PaymentDAO {
    @Override
    public Payment find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Payment> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Payment entity) throws Exception {
        return 0< CrudUtil.<Integer>execute("insert into payment values(?,?,?)",entity.getId(),entity.getPrice(),entity.getOid());
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
