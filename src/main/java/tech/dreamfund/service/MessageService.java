package tech.dreamfund.service;

import tech.dreamfund.model.Message;

import java.util.List;

/**
 * Created by xiasu on 2017/7/9.
 */
public interface MessageService {
    void addMessage(Message message);
    void updateMessage(Message message);
    Message queryMessageById(int id);
    List<Message> queryMessageByRid(int rid);
}
