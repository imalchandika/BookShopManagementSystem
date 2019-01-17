package lk.ijse.dep.BookShop.business;

import lk.ijse.dep.BookShop.dto.*;
import lk.ijse.dep.BookShop.entity.*;

import java.util.List;
import java.util.stream.Collectors;


public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Customer) {
            Customer c = (Customer) entity;
            return (T) new CustomerDTO(c.getcId(),c.getcName(),c.getcTele());
        } else if (entity instanceof Author) {
            Author a = (Author) entity;
            return (T) new AuthorDTO(a.getaId(),a.getaName(),a.getaEmail());
        } else if(entity instanceof Publisher){
            Publisher p=(Publisher)entity;
            return (T) new PublisherDTO(p.getpId(),p.getpName(),p.getpEmail());
        }else if(entity instanceof Book){
            Book b=(Book)entity;
            return (T) new BookDTO(b.getbId(),b.getbName(),b.getbAmount(),b.getbQtyOnHand(),b.getpId(),b.getaId());
        }else if(entity instanceof OrderDetail2){
             OrderDetail2 o =(OrderDetail2)entity;
             return (T) new OrderDetail2DTO(o.getcId(),o.getoDate(),o.getPrice(),o.getId(),o.getbId());
        }else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }



    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof CustomerDTO) {
            CustomerDTO c = (CustomerDTO) dto;
            return (T) new Customer(c.getcId(),c.getcName(),c.getcTele());
        } else if (dto instanceof AuthorDTO) {
            AuthorDTO a = (AuthorDTO) dto;
            return (T) new Author(a.getaId(),a.getaName(),a.getaEmail());

        } else if(dto instanceof PublisherDTO){
           PublisherDTO p=(PublisherDTO)dto;
           return (T) new Publisher(p.getpId(),p.getpName(),p.getpEmail());

        }else if(dto instanceof BookDTO){
            BookDTO b=(BookDTO)dto;
            return (T) new Book(b.getbId(),b.getbName(),b.getbAmount(),b.getbQtyOnHand(),b.getpId(),b.getaId());
        }else if(dto instanceof OrdersDTO){
            OrdersDTO o=(OrdersDTO)dto;
            return (T) new Orders(o.getOid(),o.getDate(),o.getCustomerid());
        }else{
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

}
