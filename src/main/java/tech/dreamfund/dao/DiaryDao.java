package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tech.dreamfund.model.Diary;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Elvira on 2017/6/17.
 */
public interface DiaryDao {
    @Insert("insert into diary values(#{id},#{title},#{leftContent},#{rightContent},#{writeTime},#{accountId})")
    void saveDiary(Diary diary);
    @Delete("delete from diary where id=#{id}")
    void deleteDiary(int id);
    @Select("select * from diary where id=#{id}")
    Diary queryDiaryById(int id);
    @Select("select * from diary where id LIKE #{num}")
    List<Diary> queryDiaryList(String num);
    @Select("select id from diary")
    List<Integer> queryYearList();
    @Select("select id from diary where id LIKE #{year}")
    List<Integer> queryMonthList(String year);
}
