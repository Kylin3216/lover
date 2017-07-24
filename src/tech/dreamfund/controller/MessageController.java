package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.Message;
import tech.dreamfund.service.MessageService;
import tech.dreamfund.util.ConstantsString;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xiasu on 2017/7/9.
 */
@Controller
@SessionAttributes({"account"})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/message")
    public String wish(ModelMap map) {
        Account account = (Account) map.get("account");
        if (account == null || account.getId() == 0) {
            return "redirect:/index";
        }
        List<Message> messageList = messageService.queryMessageByRid(account.getId());
        map.put("messageList", messageList);
        return "message";
    }

    @RequestMapping("/sendMessage")
    public String sendMessage(int receiverId, int type, ModelMap map, HttpServletResponse response) {
        try {
            Account account = (Account) map.get("account");
            String nickName;
            if (account.getUserDetail() == null) {
                nickName = account.getTelephone();
            } else {
                nickName = account.getUserDetail().getNickName();
            }
            Message message = getMessage(type, nickName);
            message.setSenderId(account.getId());
            message.setReceiverId(receiverId);
            messageService.addMessage(message);
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/readMessage")
    public String readMessage(int id) {
        Message message = messageService.queryMessageById(id);
        message.setState(true);
        messageService.updateMessage(message);
        switch (message.getType()) {
            case 6:
                return "redirect:/wish";
            case 4:
                return "redirect:/diary?mode=2";
            case 3:
                return "redirect:/diary?mode=0";
            case 5:
                return "redirect:/album";
        }
        return "redirect:/message";
    }

    @RequestMapping("/agreeBind")
    public String agreeBind(int id, HttpServletResponse response) {
        try {
            Message message = messageService.queryMessageById(id);
            Message message1 = getMessage(1, "");
            message1.setSenderId(message.getSenderId());
            message1.setReceiverId(message.getReceiverId());
            Message message2 = getMessage(1, "");
            message2.setSenderId(message.getReceiverId());
            message2.setReceiverId(message.getSenderId());
            message.setIsDone(1);
            message.setState(true);
            messageService.updateMessage(message);
            messageService.addMessage(message1);
            messageService.addMessage(message2);
            response.getWriter().write(message.getSenderId() + "|" + message.getReceiverId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/refuseBind")
    public String refuseBind(int id) {
            Message message = messageService.queryMessageById(id);
            Message message1 = getMessage(2, "");
            message1.setSenderId(message.getReceiverId());
            message1.setReceiverId(message.getSenderId());
            message.setIsDone(2);
            message.setState(true);
            messageService.updateMessage(message);
            messageService.addMessage(message1);
        return "redirect:/message";
    }


    private Message getMessage(int type, String nickName) {
        Message message = new Message(new Date(), type, false);
        String content;
        switch (type) {
            case 0:
                content = "向您发送了绑定对象邀请";
                break;
            case 1:
                content = "恭喜！绑定成功！你们将可以进行情侣互动";
                break;
            case 2:
                content = "抱歉！对方拒绝了您的绑定邀请";
                break;
            case 3:
                content = "发表了新的心情，点击前往查看";
                break;
            case 4:
                content = "给您发送了一份情书，点击前往查看";
                break;
            case 5:
                content = "添加了新的照片，点击前往查看";
                break;
            case 6:
                content = "在愿望广场许下了新的愿望，点击前往查看";
                break;
            default:
                content = "";
                break;
        }
        message.setContent(nickName + content);
        return message;
    }

}
