package lk.ijse.dep.BookShop.dao.custom.impl;

import lk.ijse.dep.BookShop.dao.CrudUtil;
import lk.ijse.dep.BookShop.dao.custom.QuaryDAO;
import lk.ijse.dep.BookShop.entity.OrderDetail;
import lk.ijse.dep.BookShop.entity.OrderDetail2;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuaryDAOimpl implements QuaryDAO {

    @Override
    public List<OrderDetail2> findOrderDetailsWithPaymentDetail(String orderId) throws Exception {
         ResultSet rst = CrudUtil.execute("SELECT distinct customerId,oDate,price,id,bId from orderbook\n" +
                "INNER join payment p on orderbook.oId = p.oId\n" +
                "inner join orderdetail o on orderbook.oId = o.orderId where orderbook.oId=?", orderId);
        List<OrderDetail2> orderdetailist = new ArrayList<>();
        while(rst.next()){

             orderdetailist.add(new OrderDetail2(rst.getString(1),
                     rst.getDate(2),
                     rst.getDouble(3),
                     rst.getString(4),
                     rst.getString(5)));
         }
        return orderdetailist;
    }
}
