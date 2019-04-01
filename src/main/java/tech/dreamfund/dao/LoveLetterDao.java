package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.dreamfund.model.LoveLetter;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface LoveLetterDao {
    @Insert("insert into loveletter values(0,#{content},#{accountId},#{loverId},#{state},#{writeTime},#{sendTime})")
    void saveLetter(LoveLetter loveLetter);

    @Update("update loveletter set content=#{content},state=#{state},writetime=#{writeTime},sendtime=#{sendTime}")
    void updateLetter(LoveLetter loveLetter);

    @Delete("delete from loveletter where id=#{id}")
    void deleteLetter(int id);

    @Select("select * from loveletter where accountid=#{0} and state=#{1}")
    List<LoveLetter> queryLetter(int aid, int state);
}
