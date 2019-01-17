package lk.ijse.dep.BookShop.dto;

public class OrderDetailDTO extends  SuperDTO{
    private String oId;
    private String bId;
    private int qty;
    private double unitPrice;

    public OrderDetailDTO(String oId, String bId, int qty, double unitPrice) {
        this.setoId(oId);
        this.setbId(bId);
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
