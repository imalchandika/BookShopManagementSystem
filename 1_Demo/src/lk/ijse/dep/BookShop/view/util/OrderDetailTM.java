package lk.ijse.dep.BookShop.view.util;

public class OrderDetailTM {
    private String oid;
    private String bid;
    private int qty;
    private double unitprice;

    public OrderDetailTM(String oid, String bid, int qty, double unitprice) {
        this.setOid(oid);
        this.setBid(bid);
        this.setQty(qty);
        this.setUnitprice(unitprice);
    }


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }
}
