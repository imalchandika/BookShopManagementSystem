package lk.ijse.dep.BookShop.business.custom.impl;

import lk.ijse.dep.BookShop.business.Converter;
import lk.ijse.dep.BookShop.business.custom.PublisherBO;
import lk.ijse.dep.BookShop.dao.DAOFactory;
import lk.ijse.dep.BookShop.dao.custom.PublisherDAO;
import lk.ijse.dep.BookShop.dto.PublisherDTO;

import java.util.List;

public class PublisherBOimpl implements PublisherBO {
    PublisherDAO publisherDAO;

    public PublisherBOimpl(){

       publisherDAO =DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PUBLISHER);
    }

    @Override
    public List<PublisherDTO> getPublishers() throws Exception {
        return Converter.getDTOList(publisherDAO.findAll());
    }

    @Override
    public boolean createPublisher(PublisherDTO dto) throws Exception {
        return publisherDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updatePublisher(PublisherDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deletePublisher(String memberID) throws Exception {
        return false;
    }

    @Override
    public PublisherDTO findPublisher(String id) throws Exception {
        return null;
    }
}
