package com.app.raghu.service;

import java.util.List;

import com.app.raghu.dto.request.MessageRequest;
import com.app.raghu.entity.Message;

public interface IMessageService {
    public Message createMessage(Message message);

    public List<Message> getAllMessages();
}
