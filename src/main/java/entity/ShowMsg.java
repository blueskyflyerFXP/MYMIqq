package entity;

public class ShowMsg {
    private byte[] headPhoto;
    private String user;
    private String chatDate;
    private String laterMsg;
    private int NumOfMsg;

    public ShowMsg() {
    }

    public ShowMsg(byte[] headPhoto, String user, String chatDate, String laterMsg, int numOfMsg) {
        this.headPhoto = headPhoto;
        this.user = user;
        this.chatDate = chatDate;
        this.laterMsg = laterMsg;
        NumOfMsg = numOfMsg;
    }

    public byte[] getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(byte[] headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public String getLaterMsg() {
        return laterMsg;
    }

    public void setLaterMsg(String laterMsg) {
        this.laterMsg = laterMsg;
    }

    public int getNumOfMsg() {
        return NumOfMsg;
    }

    public void setNumOfMsg(int numOfMsg) {
        NumOfMsg = numOfMsg;
    }
}
