package tech.dreamfund.dao;

import org.apache.ibatis.annotations.*;
import tech.dreamfund.model.Album;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface AlbumDao {
    @Insert("insert into album values(seq_album.nextval,#{albumName},#{createTime},#{accountId},#{description})")
    void  createAlbum(Album album);
    @Update("update album set albumName=#{albumName},description=#{description} where id=#{id}")
    void updateAlbum(Album album);
    @Delete("delete from album where id=#{id}")
    void  deleteAlbum(int id);
    @Select("select * from album order by id")
    @ResultMap("album")
    List<Album> queryAllAlbum();
}
