package lk.ijse.dep.BookShop.entity;



import java.time.LocalDate;

public class Orders extends SuperEntity{

    private String Oid;
    private LocalDate Date;
    private String customerid;

    public Orders(String oid, LocalDate date, String customerid) {
        setOid(oid);
        setDate(date);
        this.setCustomerid(customerid);

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


}
