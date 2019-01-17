package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.AuthorDAO;
import lk.ijse.dep.BookShop.entity.Author;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOimpl implements AuthorDAO {
    @Override
    public Author find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Author where aId=?", key);
        if(rst.next()){
            return new Author(rst.getString(1),
                    rst.getString(2)
                    ,rst.getString(3));
        }
        return null;
    }

    @Override
    public List<Author> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM author");
         ArrayList<Author> authors = new ArrayList<>();
        while (rst.next()){
            authors.add(new Author(rst.getString(1),
                    rst.getString(2)
                    ,rst.getString(3)));
        }
        return authors;
    }

    @Override
    public boolean save(Author entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("insert into Author values(?,?,?)",entity.getaId(),entity.getaName(),entity.getaEmail());
    }

    @Override
    public boolean update(Author entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("update author set aName=?,aEmail=? where aId=?",entity.getaName(),entity.getaEmail(),entity.getaId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return 0<CrudUtil.<Integer>execute("delete from Author where aId=?",key);
    }
}
