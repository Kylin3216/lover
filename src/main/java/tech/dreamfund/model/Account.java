package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by xiasu on 2017/6/4.
 */
public class Account {
    private int id;
    private String accountName;
    private String email;
    private String telephone;
    private String password;
    private int type;
    private Date lastLoginTime;
    private int state;
    private int loverId=-1;
    public int getLoverId() {
        return loverId;
    }

    public void setLoverId(int loverId) {
        this.loverId = loverId;
    }

    /*账户与用户信息一对一*/
    private UserDetail userDetail;

    public Account() {
    }

    public Account(String accountName, String email, String telephone, String password, int type, Date lastLoginTime) {
        this.accountName = accountName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.type = type;
        this.lastLoginTime = lastLoginTime;
    }

    public Account(int id, String accountName, String email, String telephone, String password, int type, Date lastLoginTime) {
        this.id = id;
        this.accountName = accountName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.type = type;
        this.lastLoginTime = lastLoginTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", lastLoginTime=" + lastLoginTime +
                ", state=" + state +
                ", loverId=" + loverId +
                ", userDetail=" + userDetail +
                '}';
    }
}
