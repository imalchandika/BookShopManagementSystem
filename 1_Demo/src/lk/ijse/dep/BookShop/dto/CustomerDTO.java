package lk.ijse.dep.BookShop.dto;

public class CustomerDTO extends  SuperDTO{

    private String cId;
    private String cName;
    private String cTele;

    public CustomerDTO(String cId, String cName, String cTele) {
        this.setcId(cId);
        this.setcName(cName);
        this.setcTele(cTele);
    }


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTele() {
        return cTele;
    }

    public void setcTele(String cTele) {
        this.cTele = cTele;
    }
}
