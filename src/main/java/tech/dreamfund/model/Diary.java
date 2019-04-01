package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by Elvira on 2017/6/17.
 */
public class Diary {
    private int id;
    private String title;
    private String leftContent;
    private String rightContent;
    private Date writeTime;
    private  int accountId;

    public Diary() {
    }

    public Diary(int id, String title, String leftContent, String rightContent, Date writeTime, int accountId) {
        this.id = id;
        this.title = title;
        this.leftContent = leftContent;
        this.rightContent = rightContent;
        this.writeTime = writeTime;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeftContent() {
        return leftContent;
    }

    public void setLeftContent(String leftContent) {
        this.leftContent = leftContent;
    }

    public String getRightContent() {
        return rightContent;
    }

    public void setRightContent(String rightContent) {
        this.rightContent = rightContent;
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
