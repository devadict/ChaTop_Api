package com.app.raghu.entity;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rentals")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue

    private Integer id;

    private String name;
    private Double surface;
    private Double price;
    private String picture;
    private String description;
    
    @CreatedDate
    private LocalDateTime created_at;
    
    @LastModifiedDate
    private LocalDateTime updated_at;
    
    // @ManyToOne
    @JoinColumn(name = "owner_id")
    private Integer owner_id;
}
