package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tech.dreamfund.model.Mood;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface MoodDao {
    @Insert("insert into mood values(seq_mood.nextval,#{content},#{writeTime},#{accountId})")
    void saveMood(Mood mood);
    @Delete("delete from mood where id=#{id}")
    void deleteMood(int id);
    @Select("select * from mood where accountId=#{aid} order by writeTime desc ")
    List<Mood> queryAllMoodByAid(int aid);
}
