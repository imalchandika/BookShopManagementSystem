package lk.ijse.dep.BookShop.view.util;


import java.util.Date;

public class OrderDetail2TM {
    private String cid;
    private Date odate;
    private double price;
    private String id;
    private String bid;

    public OrderDetail2TM(String cid, Date odate, double price, String id, String bid) {
        this.setCid(cid);
        this.setOdate(odate);
        this.setPrice(price);
        this.setId(id);
        this.setBid(bid);
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
