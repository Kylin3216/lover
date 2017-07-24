package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tech.dreamfund.model.Photo;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface PhotoDao {
    @Insert("insert into photo values(seq_photo.nextval,#{photoName},#{albumId},#{image})")
    void addPhoto(Photo photo);
@Delete("delete from photo where id=#{id}")
    void deletePhoto(int id);
    @Select("select * from photo where id=#{id}")
    Photo queryPhoto(int id);
    @Select("select * from photo where albumId=#{aid}")
    List<Photo>  queryPhotoByAid(int aid);
}
