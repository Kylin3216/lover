package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.dreamfund.model.Wish;

import java.util.List;

/**
 * Created by xiasu on 2017/6/29.
 */
public interface WishDao {
    @Insert("insert into wish values(0,#{content},#{wishTime},#{isFinished},#{accountId})")
    void  saveWish(Wish wish);
    @Delete("delete from wish where id=#{id}")
    void deleteWish(int id);
    @Update("update wish set #{isFinished} where id=#{id}")
    void updateWish(Wish wish);
    @Select("select * from wish where id=#{id}")
    Wish queryWishById(int id);
    @Select("select * from wish where accountId=#{aid}")
    List<Wish> queryWishByAid(int aid);
}
