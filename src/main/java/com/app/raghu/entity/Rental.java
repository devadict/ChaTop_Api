package com.app.raghu.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Identifier of the rental", example = "4")
    private Integer id;

    @Schema(description = "Name of the rental", example = "Villa")
    private String name;

    @Schema(description = "Surface of the rental", example = "14.0")
    private Double surface;

    @Schema(description = "Price of the rental", example = "35.0")
    private Double price;

    @Schema(description = "Picture pathe of the rental", example = "src/resources/static/images")
    private String picture;

	@Schema(description = "First time rental was created", example = "2023-04-06T15:33:45")
    private String description;
    
	@Schema(description = "Last time informations were modified", example = "2023-04-06T15:33:45")
    @CreatedDate
    private LocalDateTime created_at;
    
    @LastModifiedDate
    private LocalDateTime updated_at;
    
    // @ManyToOne
    @JoinColumn(name = "owner_id")
    private Integer owner_id;
}
