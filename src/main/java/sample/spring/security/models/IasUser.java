package sample.spring.security.models;


public class IasUser {

    private Long Id;
    private String value;
    private String familyName;
    private String givenName;
    private String userName;

    public IasUser() {
    }

    public IasUser(Long id, String value, String familyName, String givenName, String userName) {
        Id = id;
        this.value = value;
        this.familyName = familyName;
        this.givenName = givenName;
        this.userName = userName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Ias{" +
                "Id=" + Id +
                ", value='" + value + '\'' +
                ", familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
