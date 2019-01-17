package lk.ijse.dep.BookShop.business.custom.impl;

import lk.ijse.dep.BookShop.business.Converter;
import lk.ijse.dep.BookShop.business.custom.BookBO;
import lk.ijse.dep.BookShop.dao.DAOFactory;

import lk.ijse.dep.BookShop.dao.custom.BookDAO;
import lk.ijse.dep.BookShop.dto.BookDTO;

import java.util.List;

public class BookBOimpl implements BookBO {

    BookDAO bookDAO;

    public BookBOimpl() {
        bookDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);
    }
    @Override
    public List<BookDTO> getBooks() throws Exception {
        return Converter.getDTOList(bookDAO.findAll());
    }

    @Override
    public boolean createBook(BookDTO dto) throws Exception {
        return bookDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateBook(BookDTO dto) throws Exception {
        return bookDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteBook(String id) throws Exception {
        return bookDAO.delete(id);
    }

    @Override
    public BookDTO findBook(String id) throws Exception {
        return Converter.getDTO(bookDAO.find(id));
    }
}
