package tech.dreamfund.model;

import java.util.Date;
import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public class Album implements Comparable{
    private  int id;
    private String albumName;
    private Date createTime;
    private int accountId;
    private String description;
    private List<Photo> photos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", createTime=" + createTime +
                ", accountId=" + accountId +
                ", description='" + description + '\'' +
                ", photos=" + photos +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Album  a=(Album)o;
        return this.getId()-a.getId();
    }
}
