package lk.ijse.dep.BookShop.view.util;

public class PublisherTM {
    private String pid;
    private String pname;
    private String pemail;

    public PublisherTM(String pid, String pname, String pemail) {
        this.setPid(pid);
        this.setPname(pname);
        this.setPemail(pemail);
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }
}
