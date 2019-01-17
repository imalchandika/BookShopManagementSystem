package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.CustomerDAO;
import lk.ijse.dep.BookShop.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public Customer find(String key) throws Exception {
        ResultSet rst=CrudUtil.execute("SELECT * FROM member where mId=?",key);
        if(rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    @Override
    public List<Customer> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer");
        List<Customer> customerList=new ArrayList<>();
        while(rst.next()){
            customerList.add(new Customer(rst.getString(1)
                    ,rst.getString(2),
                    rst.getString(3)));
        }
        return customerList;
    }

    @Override
    public boolean save(Customer entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("insert into customer values(?,?,?)",entity.getcId(),entity.getcName(),entity.getcTele());
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("update Customer set cName=?,cTele=? where cid=?",entity.getcName(),
                entity.getcTele(),entity.getcId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return 0<CrudUtil.<Integer>execute("delete from customer where cId=?",key);
    }
}
