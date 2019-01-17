package lk.ijse.dep.BookShop.business.custom;

import lk.ijse.dep.BookShop.business.SuperBO;

import lk.ijse.dep.BookShop.dto.PublisherDTO;

import java.util.List;

public interface PublisherBO extends SuperBO {
    List<PublisherDTO> getPublishers() throws Exception;

    boolean createPublisher(PublisherDTO dto) throws Exception;

    boolean updatePublisher(PublisherDTO dto) throws Exception;

    boolean deletePublisher(String memberID) throws Exception;

    PublisherDTO findPublisher(String id) throws Exception;
}
