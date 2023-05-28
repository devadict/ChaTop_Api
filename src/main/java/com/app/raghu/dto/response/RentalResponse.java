package com.app.raghu.dto.response;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalResponse {    
    private Integer owner_id;
    private String name;
    private Double price;
    private Double surface;
    private String picture;
    private String description;
}
