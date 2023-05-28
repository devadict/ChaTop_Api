package com.app.raghu.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequest {
    private Integer id;
    private String name;
    private Double price;
    private Double surface;
    private MultipartFile picture;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
}
