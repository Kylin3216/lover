package tech.dreamfund.service;

import tech.dreamfund.model.Photo;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface PhotoService {
    void addPhoto(Photo photo);

    void deletePhoto(int id);

    Photo queryPhoto(int id);

    List<Photo> queryPhotoByAid(int aid);
}
