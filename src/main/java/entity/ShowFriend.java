package entity;

public class ShowFriend {
    private String name;
    private byte[] photo;
    private String signure;
    public ShowFriend(){}
    public ShowFriend(String name, byte[] photo, String signure) {
        this.name = name;
        this.photo = photo;
        this.signure = signure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getSignure() {
        return signure;
    }

    public void setSignure(String signure) {
        this.signure = signure;
    }
}
