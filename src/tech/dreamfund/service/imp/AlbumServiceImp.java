package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.AlbumDao;
import tech.dreamfund.model.Album;
import tech.dreamfund.service.AlbumService;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Service
public class AlbumServiceImp implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public void createAlbum(Album album) {
        albumDao.createAlbum(album);
    }

    @Override
    public void updateAlbum(Album album) {
        albumDao.updateAlbum(album);
    }

    @Override
    public void deleteAlbum(int id) {
        albumDao.deleteAlbum(id);
    }

    @Override
    public List<Album> queryAllAlbum() {
        return albumDao.queryAllAlbum();
    }
}
