package lk.ijse.dep.BookShop.view.util;

public class AuthorTM {
    private String aid;
    private String aname;
    private String aemail;

    public AuthorTM(String aid, String aname, String aemail) {
        this.setAid(aid);
        this.setAname(aname);
        this.setAemail(aemail);
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAemail() {
        return aemail;
    }

    public void setAemail(String aemail) {
        this.aemail = aemail;
    }
}
