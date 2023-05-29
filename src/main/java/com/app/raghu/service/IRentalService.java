package com.app.raghu.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.app.raghu.dto.request.RentalRequest;
import com.app.raghu.dto.response.ListRentalResponse;
import com.app.raghu.dto.response.RentalResponse;
import com.app.raghu.entity.Rental;

public interface IRentalService {

    public Rental save(RentalResponse rental);

    public Optional<Rental> getOneRental(Integer id);

    public ListRentalResponse getAllRentals();

}
