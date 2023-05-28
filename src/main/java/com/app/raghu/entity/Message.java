package com.app.raghu.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "rental_id")
    private Integer rental_id;

    @JoinColumn(name = "user_id")
    private Integer user_id;
    
    private String message;

    @CreationTimestamp
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}
