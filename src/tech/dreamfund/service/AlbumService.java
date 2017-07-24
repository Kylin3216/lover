package tech.dreamfund.service;

import tech.dreamfund.model.Album;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface AlbumService {
    void  createAlbum(Album album);
    void updateAlbum(Album album);
    void  deleteAlbum(int id);
    List<Album> queryAllAlbum();
}
