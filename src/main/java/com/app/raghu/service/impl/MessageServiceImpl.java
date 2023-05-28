package com.app.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.dto.request.MessageRequest;
import com.app.raghu.entity.Message;
import com.app.raghu.repository.MessageRepository;
import com.app.raghu.repository.RentalRepository;
import com.app.raghu.repository.UserRepository;
import com.app.raghu.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private RentalRepository rentalRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messagerRepository;

    public Message createMessage(Message message) {
        messagerRepository.save(message);

        return message;
    }

    public List<Message> getAllMessages() {
        List<Message> messages =  messagerRepository.findAll();

        return messages;
    }
    

}
