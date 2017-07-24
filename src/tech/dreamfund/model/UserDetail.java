package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by xiasu on 2017/6/4.
 */
public class UserDetail {
    private int id;
    private int accountId;
    private String nickName="";
    private String sex="";
    private Date birth=new Date();
    private int bloodTypeId=1;
    private String address="";

    public UserDetail() {
    }

    public UserDetail(int accountId, String sex) {
        this.accountId = accountId;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getBloodTypeId() {
        return bloodTypeId;
    }

    public void setBloodTypeId(int bloodTypeId) {
        this.bloodTypeId = bloodTypeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", bloodTypeId=" + bloodTypeId +
                ", address='" + address + '\'' +
                '}';
    }
}
