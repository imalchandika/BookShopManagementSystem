package lk.ijse.dep.BookShop.dto;

public class AuthorDTO extends SuperDTO{
    private String aId;
    private String aName;
    private String aEmail;

    public AuthorDTO(String aId, String aName, String aEmail) {
        this.setaId(aId);
        this.setaName(aName);
        this.setaEmail(aEmail);
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }
}
