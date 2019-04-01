package tech.dreamfund.model;


import java.util.Arrays;

/**
 * Created by xiasu on 2017/6/24.
 */
public class Photo {
    private int id;
    private String photoName;
    private int albumId;
    private byte[] image;

    public Photo() {
    }

    public Photo(String photoName, int albumId) {
        this.photoName = photoName;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photoName='" + photoName + '\'' +
                ", albumId=" + albumId +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
