package lk.ijse.dep.BookShop.business.custom.impl;

import lk.ijse.dep.BookShop.business.Converter;
import lk.ijse.dep.BookShop.business.custom.AuthorBO;
import lk.ijse.dep.BookShop.dao.DAOFactory;
import lk.ijse.dep.BookShop.dao.custom.AuthorDAO;
import lk.ijse.dep.BookShop.dto.AuthorDTO;
import lk.ijse.dep.BookShop.entity.Author;

import java.util.List;

public class AuthorBOimpl implements AuthorBO {
    AuthorDAO authorDAO;
    public AuthorBOimpl(){
        authorDAO =DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.AUTHUR);
    }

    @Override
    public List<AuthorDTO> getAuthors() throws Exception {
        return Converter.getDTOList(authorDAO.findAll());
    }

    @Override
    public boolean createAuthor(AuthorDTO dto) throws Exception {
        return authorDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateAuthor(AuthorDTO dto) throws Exception {
        return authorDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteAuthor(String authorID) throws Exception {
        return authorDAO.delete(authorID);
    }

    @Override
    public AuthorDTO findAuthor(String id) throws Exception {

        return Converter.getDTO(authorDAO.find(id));
    }
}
