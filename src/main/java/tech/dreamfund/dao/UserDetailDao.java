package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.dreamfund.model.UserDetail;

/**
 * Created by xiasu on 2017/6/4.
 */
public interface UserDetailDao {
    @Insert("insert into userdetail values(0,#{accountId},#{nickName},#{sex},#{birth},#{bloodTypeId},#{address})")
    void saveDetail(UserDetail userDetail);
    @Update("update userdetail set nickname=#{nickName},sex=#{sex},birth=#{birth},bloodtypeid=#{bloodTypeId},address=#{address} where id=#{id}")
    void updateDetail(UserDetail userDetail);
    @Select("select * from userdetail where accountid=#{uid}")
    UserDetail queryDetailByUid(int uid);
}
