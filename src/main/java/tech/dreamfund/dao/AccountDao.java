package tech.dreamfund.dao;

import org.apache.ibatis.annotations.*;
import tech.dreamfund.model.Account;

/**
 * Created by xiasu on 2017/6/4.
 */
public interface AccountDao {
    @Insert("insert into account values(#{id},#{accountName},#{email},#{telephone},#{password},#{type},#{lastLoginTime},#{state},#{loverId})")
    void addAccount(Account account);

    @Delete("delete from account where id=#{id}")
    void delAccount(int id);

    @Update("update account set email=#{email},telephone=#{telephone},password=#{password},type=#{type},lastlogintime=#{lastLoginTime} where id=#{id}")
    void updateAccount(Account account);

    @Update("update account set email=#{email} where id=#{id}")
    void updateEmail(Account account);

    @Update("update account set telephone=#{telephone} where id=#{id}")
    void updateTelephone(Account account);

    @Update("update account set ,password=#{password} where id=#{id}")
    void updatePassword(Account account);

    @Update("update account set type=#{type} where id=#{id}")
    void updateType(Account account);

    @Update("update account set loverId=#{loverId} where id=#{id}")
    void updateLover(Account account);

    @Update("update account set lastlogintime=#{lastLoginTime} where id=#{id}")
    void updateLastLoginTime(Account account);

    @Select("select * from account where id=#{id}")
    @ResultMap(value = "user")
    Account queryAccountById(int id);


    @Select("select id from account order by id DESC limit 1")
    Integer queryLastId();

    @Select("select * from account where accountName=#{arg0} and password=#{arg1}")
    @ResultMap(value = "user")
    Account confirmByAccountName(String accountName,String password);

    @Select("select * from account where email=#{arg0} and password=#{arg1}")
    @ResultMap(value = "user")
    Account confirmByEmail(String email,String password);

    @Select("select * from account where telephone=#{arg0} and password=#{arg1}")
    @ResultMap(value = "user")
    Account confirmByTelephone(String telephone,String password);

    @Select("select * from account where accountname=#{accountName}")
    @ResultMap(value = "user")
    Account queryByAccountName(String accountName);

    @Select("select * from account where email=#{email}")
    @ResultMap(value = "user")
    Account queryByEmail(String email);

    @Select("select * from account where telephone=#{telephone}")
    @ResultMap(value = "user")
    Account queryByTelephone(String telephone);
}
