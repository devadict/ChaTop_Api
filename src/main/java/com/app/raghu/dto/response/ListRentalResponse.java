package com.app.raghu.dto.response;

import java.util.List;

import com.app.raghu.entity.Rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalResponse {
    
    private List<Rental> rentals;

}
