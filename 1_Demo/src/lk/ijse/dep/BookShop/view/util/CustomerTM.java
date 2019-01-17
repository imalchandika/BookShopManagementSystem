package lk.ijse.dep.BookShop.view.util;

public class CustomerTM {
    private String cid;
    private String cname;
    private String ctele;

    public CustomerTM(String cid, String cname, String ctele) {
        this.setCid(cid);
        this.setCname(cname);
        this.setCtele(ctele);
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtele() {
        return ctele;
    }

    public void setCtele(String ctele) {
        this.ctele = ctele;
    }
}
