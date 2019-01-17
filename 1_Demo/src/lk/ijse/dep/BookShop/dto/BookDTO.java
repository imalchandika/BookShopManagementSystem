package lk.ijse.dep.BookShop.dto;

public class BookDTO extends  SuperDTO{
    private String bId;
    private String bName;
    private double bAmount;
    private int bQtyOnHand;
    private String pId;
    private String aId;

    public BookDTO(String bId, String bName, double bAmount, int bQtyOnHand, String pId, String aId) {
        this.setbId(bId);
        this.setbName(bName);
        this.setbAmount(bAmount);
        this.setbQtyOnHand(bQtyOnHand);
        this.setpId(pId);
        this.setaId(aId);
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public double getbAmount() {
        return bAmount;
    }

    public void setbAmount(double bAmount) {
        this.bAmount = bAmount;
    }

    public int getbQtyOnHand() {
        return bQtyOnHand;
    }

    public void setbQtyOnHand(int bQtyOnHand) {
        this.bQtyOnHand = bQtyOnHand;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }
}

