package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by xiasu on 2017/6/24.
 */
public class LoveLetter {
    private int id;
    private String content;
    private int accountId;
    private int loverId;
    private int state;
    private Date writeTime;
    private Date sendTime;

    public LoveLetter() {
    }

    public LoveLetter(String content, int accountId, Date writeTime) {
        this.content = content;
        this.accountId = accountId;
        this.writeTime = writeTime;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getLoverId() {
        return loverId;
    }

    public void setLoverId(int loverId) {
        this.loverId = loverId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }


}
