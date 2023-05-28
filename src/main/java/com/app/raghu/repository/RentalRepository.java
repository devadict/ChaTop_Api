package com.app.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    
}
