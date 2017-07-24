package tech.dreamfund.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.dreamfund.model.Message;

import java.util.List;

/**
 * Created by xiasu on 2017/7/9.
 */
public interface MessageDao {
    @Insert("insert into message values(seq_message.nextval,#{senderId},#{receiverId},#{content},#{sendTime},#{type},#{state},#{isDone})")
    void addMessage(Message message);
    @Update("update message set state=#{state},isdone=#{isDone} where id=#{id}")
    void updateMessage(Message message);
    @Select("select * from message where id=#{id}")
    Message queryMessageById(int id);
    @Select("select * from message where receiverId=#{rid} order by sendTime desc")
    List<Message> queryMessageByRid(int rid);
}
