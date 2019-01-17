package lk.ijse.dep.BookShop.business.custom;

import lk.ijse.dep.BookShop.business.SuperBO;
import lk.ijse.dep.BookShop.dto.OrderDetail2DTO;
import lk.ijse.dep.BookShop.dto.OrdersDTO;
import lk.ijse.dep.BookShop.entity.OrderDetail2;

import java.util.List;

public interface OrderBO extends SuperBO {


    boolean createOrder(OrdersDTO dto) throws Exception;

    boolean updateOrder(OrdersDTO dto) throws Exception;

    List<OrderDetail2DTO> getOrderDetails(String orderID)throws Exception;

    OrdersDTO findOrder(String id) throws Exception;


}
