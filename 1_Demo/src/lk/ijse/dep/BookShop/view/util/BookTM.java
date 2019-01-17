package lk.ijse.dep.BookShop.view.util;

public class BookTM {
    private String bid;
    private String bname;
    private double bamount;
    private int bqtyonhand;
    private String pid;
    private String aid;

    public BookTM(String bid, String bname, double bamount, int bqtyonhand, String pid, String aid) {
        this.setBid(bid);
        this.setBname(bname);
        this.setBamount(bamount);
        this.setBqtyonhand(bqtyonhand);
        this.setPid(pid);
        this.setAid(aid);
    }


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getBamount() {
        return bamount;
    }

    public void setBamount(double bamount) {
        this.bamount = bamount;
    }

    public int getBqtyonhand() {
        return bqtyonhand;
    }

    public void setBqtyonhand(int bqtyonhand) {
        this.bqtyonhand = bqtyonhand;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
