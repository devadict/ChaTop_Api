package com.app.raghu.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.dto.request.MessageRequest;
import com.app.raghu.dto.response.StringResponse;
import com.app.raghu.entity.Message;
import com.app.raghu.entity.Rental;
import com.app.raghu.entity.User;
import com.app.raghu.repository.MessageRepository;
import com.app.raghu.repository.RentalRepository;
import com.app.raghu.repository.UserRepository;
import com.app.raghu.service.IMessageService;
import com.app.raghu.service.IRentalService;
import com.app.raghu.service.IUserService;

@RestController
@RequestMapping("api/messages")
public class MessageRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IRentalService rentalService;

    @PostMapping
    public ResponseEntity<StringResponse> createMessage(@RequestBody Message message, Principal p) {
        String username = p.getName();

        User user = userRepository.findByUsername(username).get();

        if (user == null) {
            return new ResponseEntity<>(new StringResponse("user does not exist"), HttpStatus.NOT_FOUND);
        }
        
        int owner = user.getId();

        Optional<Rental> rental = rentalService.getOneRental(message.getRental_id());

        if (rental.isEmpty()) {
            return new ResponseEntity<>(new StringResponse("rental does not exist"), HttpStatus.NOT_FOUND);
        }

        Integer rentalId = rental.get().getId();

        message.setUser_id(owner);
        message.setRental_id(rentalId);
        message.setCreated_at(LocalDateTime.now());
        message.setUpdated_at(LocalDateTime.now());
        message.setMessage(message.getMessage());
        messageService.createMessage(message);
  

        return ResponseEntity.ok(new StringResponse("Message sent"));
    }

    @GetMapping()
    public ResponseEntity<List<Message>> getAllMessages() {

        return ResponseEntity.ok(messageService.getAllMessages());
    }
}
