package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.PhotoDao;
import tech.dreamfund.model.Photo;
import tech.dreamfund.service.PhotoService;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Service
public class PhotoServiceImp implements PhotoService {
    @Autowired
    private PhotoDao photoDao;

    @Override
    public void addPhoto(Photo photo) {
        photoDao.addPhoto(photo);
    }

    @Override
    public void deletePhoto(int id) {
        photoDao.deletePhoto(id);
    }

    @Override
    public Photo queryPhoto(int id) {
        return photoDao.queryPhoto(id);
    }

    @Override
    public List<Photo> queryPhotoByAid(int aid) {
        return photoDao.queryPhotoByAid(aid);
    }

}
