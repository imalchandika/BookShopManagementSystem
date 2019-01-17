package lk.ijse.dep.BookShop.dto;

import java.time.LocalDate;
import java.util.List;

public class OrdersDTO extends SuperDTO{

    private String Oid;
    private LocalDate Date;
    private String customerid;
    private List<PaymentDTO> paymentDTOS;
    private List<OrderDetailDTO> orderDetailDTOS;

    public OrdersDTO(String oid, LocalDate date, String customerid, List<PaymentDTO> paymentDTOS, List<OrderDetailDTO> orderDetailDTOS) {
        setOid(oid);
        setDate(date);
        this.setCustomerid(customerid);
        this.setPaymentDTOS(paymentDTOS);
        this.setOrderDetailDTOS(orderDetailDTOS);
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public List<PaymentDTO> getPaymentDTOS() {
        return paymentDTOS;
    }

    public void setPaymentDTOS(List<PaymentDTO> paymentDTOS) {
        this.paymentDTOS = paymentDTOS;
    }

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
        this.orderDetailDTOS = orderDetailDTOS;
    }
}
