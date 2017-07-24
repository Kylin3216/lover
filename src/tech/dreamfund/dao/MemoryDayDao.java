package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.dreamfund.model.MemoryDay;

import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
public interface MemoryDayDao {
    @Insert("insert into memoryDay values(seq_memoryDay.nextval,#{memoryDate},#{content},#{accountId})")
    void saveMemoryDay(MemoryDay memoryDay);
    @Delete("delete from memoryday where id=#{id}")
    void deleteMemoryDay(int id);
    @Update("update memoryday set memorydate=#{memoryDate},content=#{content} where id=#{id}")
    void updateMemoryDay(MemoryDay memoryDay);
    @Select("select * from memoryday where accountid=#{aid}")
    List<MemoryDay> queryMemoryDayByAid(int aid);
}
