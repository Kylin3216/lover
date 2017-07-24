package tech.dreamfund.model;

import java.util.Date;

/**
 * Created by xiasu on 2017/6/24.
 */
public class MemoryDay{
    private int id;
    private Date memoryDate;
    private String content;
    private int accountId;

    public MemoryDay() {
    }

    public MemoryDay(Date memoryDate, String content, int accountId) {
        this.memoryDate = memoryDate;
        this.content = content;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMemoryDate() {
        return memoryDate;
    }

    public void setMemoryDate(Date memoryDate) {
        this.memoryDate = memoryDate;
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
}