package lk.ijse.dep.BookShop.view.util;

public class PaymentTM {
    private String id;
    private String oid;
    private double price;


    public PaymentTM(String id, String oid, double price) {
        this.setId(id);
        this.setOid(oid);
        this.setPrice(price);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
