package lk.ijse.dep.BookShop.dao;



import lk.ijse.dep.BookShop.dao.custom.OrderDetailDAO;
import lk.ijse.dep.BookShop.dao.custom.impl.*;
import lk.ijse.dep.BookShop.dto.OrdersDTO;
import lk.ijse.dep.BookShop.entity.OrderDetail;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes{
        AUTHUR,BOOK,PAYMENT, CUSTOMER,PUBLISHER,ORDERS,ORDERDETAIL,QUARY;
    }



    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case AUTHUR:
                return (T) new AuthorDAOimpl();
            case BOOK:
                return (T) new BookDAOimpl();
            case PAYMENT:
                return (T) new PaymentDAOimpl();
            case CUSTOMER:
                return (T) new CustomerDAOimpl();
            case PUBLISHER:
                return (T) new PublisherDAOimpl();
            case ORDERS:
                return (T) new OrderDAOimpl();
            case QUARY:
                return (T) new QuaryDAOimpl();
            case ORDERDETAIL:
                return (T) new OrderDetailDAOimpl();
            default:
                return null;
        }
    }

//    public CustomerDAO getCustomerDAO(){
//        return new CustomerDAOImpl();
//    }
//
//    public ItemDAO getItemDAO(){
//        return new ItemDAOImpl();
//    }

}
