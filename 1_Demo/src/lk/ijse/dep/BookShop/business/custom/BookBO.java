package lk.ijse.dep.BookShop.business.custom;

import lk.ijse.dep.BookShop.business.SuperBO;
import lk.ijse.dep.BookShop.dto.BookDTO;

import java.util.List;

public interface BookBO extends SuperBO {
    List<BookDTO> getBooks() throws Exception;

    boolean createBook(BookDTO dto) throws Exception;

    boolean updateBook(BookDTO dto) throws Exception;

    boolean deleteBook(String id) throws Exception;

    BookDTO findBook(String id) throws Exception;
}
