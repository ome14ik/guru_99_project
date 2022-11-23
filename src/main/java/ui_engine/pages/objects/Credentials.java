package ui_engine.pages.objects;

public class Credentials {

    private String userId;
    private String password;
    private boolean credExist;
    private String createdDate;
    private String createdTime;

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }


    public boolean isCredExist() {
        return credExist;
    }

    public void setCredExist(boolean credExist) {
        this.credExist = credExist;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
