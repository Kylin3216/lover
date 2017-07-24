package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by xiasu on 2017/6/24.
 */
public class Mood {
    private int id;
    private String content;
    private Date writeTime;
    private int accountId;

    public Mood() {
    }

    public Mood(String content, Date writeTime, int accountId) {
        this.content = content;
        this.writeTime = writeTime;
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

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
