package com.app.raghu.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    @JsonProperty(value = "user_id")
    private Integer user_id;
    @JsonProperty(value = "rental_id")
    private Integer rental_id;

    private String message;
}
