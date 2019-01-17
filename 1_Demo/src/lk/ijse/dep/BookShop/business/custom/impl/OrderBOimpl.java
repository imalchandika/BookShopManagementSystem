package lk.ijse.dep.BookShop.business.custom.impl;


import lk.ijse.dep.BookShop.business.BOFactory;
import lk.ijse.dep.BookShop.business.Converter;
import lk.ijse.dep.BookShop.business.SuperBO;
import lk.ijse.dep.BookShop.business.custom.BookBO;
import lk.ijse.dep.BookShop.business.custom.OrderBO;
import lk.ijse.dep.BookShop.dao.DAOFactory;

import lk.ijse.dep.BookShop.dao.custom.OrderDAO;
import lk.ijse.dep.BookShop.dao.custom.OrderDetailDAO;
import lk.ijse.dep.BookShop.dao.custom.PaymentDAO;
import lk.ijse.dep.BookShop.dao.custom.QuaryDAO;
import lk.ijse.dep.BookShop.db.DBConnection;
import lk.ijse.dep.BookShop.dto.*;
import lk.ijse.dep.BookShop.entity.OrderDetail;

import lk.ijse.dep.BookShop.entity.Orders;
import lk.ijse.dep.BookShop.entity.Payment;

import java.util.List;

public class OrderBOimpl implements OrderBO {
    OrderDAO orderDAO;
    PaymentDAO paymentDAO;
    OrderDetailDAO orderDetailDAO;
    QuaryDAO quaryDAO;
    BookBO bookBO;
    public OrderBOimpl() {
        orderDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        paymentDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        orderDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
        quaryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUARY);

        bookBO = BOFactory.getInstance().getBO(BOFactory.DAOTypes.BOOK);
    }



    @Override
    public boolean createOrder(OrdersDTO dto) throws Exception {


        DBConnection.getConnection().setAutoCommit(false);

        boolean isSAVE = orderDAO.save(new Orders(dto.getOid(), dto.getDate(), dto.getCustomerid()));
        try {



            if (!isSAVE) {
                DBConnection.getConnection().rollback();
                return false;
            }
            for (PaymentDTO paymentDTO : dto.getPaymentDTOS()) {
                isSAVE = paymentDAO.save(new Payment(paymentDTO.getId(), paymentDTO.getOid(), paymentDTO.getPrice()));

                if (!isSAVE) {
                    DBConnection.getConnection().rollback();
                    return false;
                }

            }
            for (OrderDetailDTO orderDetailDTO : dto.getOrderDetailDTOS()) {
                isSAVE = orderDetailDAO.save(new OrderDetail(orderDetailDTO.getoId(),
                        orderDetailDTO.getbId(),
                        orderDetailDTO.getQty(),
                        orderDetailDTO.getUnitPrice()));


                if (!isSAVE) {

                    DBConnection.getConnection().rollback();
                    return false;
                }

                 BookDTO book = bookBO.findBook(orderDetailDTO.getbId());
                 int qty = book.getbQtyOnHand() - orderDetailDTO.getQty();
                 book.setbQtyOnHand(qty);
                 bookBO.updateBook(book);


            }

            DBConnection.getConnection().commit();

        }catch (Exception ex){

            DBConnection.getConnection().rollback();
        }finally {

            DBConnection.getConnection().setAutoCommit(true);

        }

        return true;
    }

    @Override
    public boolean updateOrder(OrdersDTO dto) throws Exception {
        return false;
    }

    @Override
    public List<OrderDetail2DTO> getOrderDetails(String orderID) throws Exception {
        return Converter.getDTOList(quaryDAO.findOrderDetailsWithPaymentDetail(orderID));
    }


    @Override
    public OrdersDTO findOrder(String id) throws Exception {
        return null;
    }
}
