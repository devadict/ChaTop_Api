package com.app.raghu.dto.request;

import java.util.List;

import com.app.raghu.dto.response.RentalResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalRequest {

    List<RentalResponse> rentals;
}
