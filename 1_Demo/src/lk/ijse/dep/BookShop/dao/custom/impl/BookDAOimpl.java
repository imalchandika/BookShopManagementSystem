package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.BookDAO;
import lk.ijse.dep.BookShop.entity.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAOimpl implements BookDAO {

    @Override
    public Book find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM book where bId=?",key);

       if(rst.next()){
            return new Book(rst.getString(1),rst.getString(2),
                    rst.getDouble(3),rst.getInt(4),
                    rst.getString(5),rst.getString(6));
        }
        return null;
    }

    @Override
    public List<Book> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from book");
        List<Book> books = new ArrayList<>();
        while (rst.next()){
            books.add(new Book(rst.getString(1),rst.getString(2),
                    rst.getDouble(3),rst.getInt(4),
                    rst.getString(5),rst.getString(6)));
        }


        return books;
    }

    @Override
    public boolean save(Book entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("insert into Book values(?,?,?,?,?,?)",entity.getbId(),
                entity.getbName(),
                entity.getbAmount(),entity.getbQtyOnHand(),entity.getaId(),entity.getpId());
    }

    @Override
    public boolean update(Book entity) throws Exception {
        return 0<CrudUtil.<Integer>execute("update Book set bName=?,bAmount=?,bQtyOnHand=? where bid=?",entity.getbName(),
                entity.getbAmount(),entity.getbQtyOnHand(),
                entity.getbId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return  0<CrudUtil.<Integer>execute("delete from book where bId=?",key);
    }
}
