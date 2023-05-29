package com.app.raghu.service.impl;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.raghu.dto.response.ListRentalResponse;
import com.app.raghu.dto.response.RentalResponse;
import com.app.raghu.entity.Rental;
import com.app.raghu.entity.User;
import com.app.raghu.repository.RentalRepository;
import com.app.raghu.repository.UserRepository;
import com.app.raghu.service.IRentalService;

import lombok.Data;

@Data
@Service
public class RentalServiceImpl implements IRentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Rental save(RentalResponse rental) {
        // add owner id and picutre path

        Rental newRental = Rental.builder()
                .name(rental.getName())
                .surface(rental.getSurface())
                .price(rental.getPrice())
                .picture(rental.getPicture())
                .created_at(LocalDateTime.now())
                .updated_at(LocalDateTime.now())
                .owner_id(rental.getOwner_id())
                .description(rental.getDescription())
                .build();

        rentalRepository.save(newRental);

        return newRental;

    }

    public ListRentalResponse getAllRentals() {
        List<Rental> rental = rentalRepository.findAll();
        return new ListRentalResponse(rental);
    }

    public Optional<Rental> getOneRental(Integer id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        return rental;
    
    }
    
}
