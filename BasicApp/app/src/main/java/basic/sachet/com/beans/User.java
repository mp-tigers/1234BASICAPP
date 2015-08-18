package basic.sachet.com.beans;

import java.util.Date;

public class User {

    //private variables
    String userId;
    String userName;
    Date dob;
    String email;
    String picUrl;
    String accountId;
    String accountType;

    public User(String userId, String userName, Date dob, String email, String picUrl, String accountId, String accountType) {
        this.userId = userId;
        this.userName = userName;
        this.dob = dob;
        this.email = email;
        this.picUrl = picUrl;
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
