package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.PublisherDAO;
import lk.ijse.dep.BookShop.entity.Publisher;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAOimpl implements PublisherDAO {

    @Override
    public Publisher find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM publisher");
        return null;
    }

    @Override
    public List<Publisher> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM publisher");
        List<Publisher> publishers = new ArrayList<>();
        while (rst.next()){
            publishers.add(new Publisher(rst.getString(1),
                    rst.getString(2)
                    ,rst.getString(3)));
        }
        return publishers;
    }

    @Override
    public boolean save(Publisher entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("insert into publisher values(?,?,?)",entity.getpId(),entity.getpName(),entity.getpEmail());
    }

    @Override
    public boolean update(Publisher entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
