package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by xiasu on 2017/6/29.
 */
public class Wish {
    private  int id;
    private  String content;
    private Date wishTime;
    private int isFinished;
    private int accountId;

    public Wish() {
    }

    public Wish(String content, Date wishTime, int isFinished, int accountId) {
        this.content = content;
        this.wishTime = wishTime;
        this.isFinished = isFinished;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWishTime() {
        return wishTime;
    }

    public void setWishTime(Date wishTime) {
        this.wishTime = wishTime;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
