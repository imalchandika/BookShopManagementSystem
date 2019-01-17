package lk.ijse.dep.BookShop.dao.custom;

import lk.ijse.dep.BookShop.dao.SuperDAO;

import lk.ijse.dep.BookShop.entity.OrderDetail;
import lk.ijse.dep.BookShop.entity.OrderDetail2;

import java.util.List;

public interface QuaryDAO extends SuperDAO {

    List<OrderDetail2> findOrderDetailsWithPaymentDetail(String orderId) throws Exception;
}
