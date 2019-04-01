package tech.dreamfund.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dreamfund.dao.MessageDao;
import tech.dreamfund.model.Message;
import tech.dreamfund.service.MessageService;

import java.util.List;

/**
 * Created by xiasu on 2017/7/9.
 */
@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    @Override
    public void updateMessage(Message message) {
        messageDao.updateMessage(message);
    }

    @Override
    public Message queryMessageById(int id) {
        return messageDao.queryMessageById(id);
    }

    @Override
    public List<Message> queryMessageByRid(int rid) {
        return messageDao.queryMessageByRid(rid);
    }
}
