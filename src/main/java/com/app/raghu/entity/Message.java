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

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue

    @Schema(description = "Message id", example = "4")
    private Integer id;

    @Schema(description = "Identifier of corresponding rental", example = "1")
    @JoinColumn(name = "rental_id")
    private Integer rental_id;

    @Schema(description = "Identifier of message author", example = "1")
    @JoinColumn(name = "user_id")
    private Integer user_id;
    
    @Schema(description = "Message content", example = "I will buy this one")
    private String message;

    @Schema(description = "First time message was created", example = "2023-04-06T15:33:45")
    @CreationTimestamp
    private LocalDateTime created_at;

    @Schema(description = "Last time message was updated", example = "2023-04-06T15:33:45")
    @LastModifiedDate
    private LocalDateTime updated_at;
}
