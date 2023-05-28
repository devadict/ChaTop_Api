package com.app.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.dto.request.MessageRequest;
import com.app.raghu.entity.Message;

public interface MessageRepository extends JpaRepository <Message, Integer> {

    // void save(MessageRequest message);
    
}
