package lk.ijse.dep.BookShop.entity;

public class Publisher extends SuperEntity{
    private String pId;
    private String pName;
    private String pEmail;

    public Publisher(String pId, String pName, String pEmail) {
        this.setpId(pId);
        this.setpName(pName);
        this.setpEmail(pEmail);
    }


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }
}
