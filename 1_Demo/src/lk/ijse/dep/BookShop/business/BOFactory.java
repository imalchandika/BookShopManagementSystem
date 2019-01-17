package lk.ijse.dep.BookShop.business;

import lk.ijse.dep.BookShop.business.custom.impl.*;

public class BOFactory {

    private static BOFactory daoFactory;

    public enum DAOTypes{
        AUTHUR,BOOK,ORDERS, CUSTOMER,PUBLISHER;
    }


    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new BOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperBO> T getBO(DAOTypes daoType) {
        switch (daoType) {
            case AUTHUR:
                return (T) new AuthorBOimpl();
            case BOOK:
                return (T) new BookBOimpl();
            case ORDERS:
                return (T) new OrderBOimpl();
            case CUSTOMER:
                return (T) new CustomerBOimpl();
            case PUBLISHER:
                return (T) new PublisherBOimpl();
            default:
                return null;
        }
    }


}
