package lk.ijse.dep.BookShop.business.custom;

import lk.ijse.dep.BookShop.business.SuperBO;
import lk.ijse.dep.BookShop.dto.AuthorDTO;

import java.util.List;

public interface AuthorBO extends SuperBO {
    List<AuthorDTO> getAuthors() throws Exception;

    boolean createAuthor(AuthorDTO dto) throws Exception;

    boolean updateAuthor(AuthorDTO dto) throws Exception;

    boolean deleteAuthor(String authorID) throws Exception;

    AuthorDTO findAuthor(String id) throws Exception;
}
