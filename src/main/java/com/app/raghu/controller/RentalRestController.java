package com.app.raghu.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.raghu.dto.request.RentalRequest;
import com.app.raghu.dto.response.ListRentalResponse;
import com.app.raghu.dto.response.RentalResponse;
import com.app.raghu.dto.response.StringResponse;
import com.app.raghu.entity.Rental;
import com.app.raghu.entity.User;
import com.app.raghu.repository.RentalRepository;
import com.app.raghu.repository.UserRepository;
import com.app.raghu.service.IRentalService;
import com.app.raghu.service.impl.UploadPhoto;

import antlr.StringUtils;

@RestController
@RequestMapping("api/rentals")
public class RentalRestController {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRentalService service;

    @PostMapping
    public ResponseEntity<StringResponse> createRental(@ModelAttribute RentalRequest rentalRequest, Principal p) throws IOException {
        String username = p.getName();

        User user = userRepository.findByUsername(username).get();

        int owner = user.getId();

        String picture;
        
        picture = UploadPhoto.uploadPicture(rentalRequest.getPicture());
        

        RentalResponse rental = new RentalResponse();
        rental.setName(rentalRequest.getName());
        rental.setSurface(rentalRequest.getSurface());
        rental.setPrice(rentalRequest.getPrice());
        rental.setDescription(rentalRequest.getDescription());
        rental.setPicture(picture);
        rental.setOwner_id(owner);

       Rental newRental = service.save(rental);

        return ResponseEntity.ok(new StringResponse("Rental Created"));
    }

    @GetMapping
    public ListRentalResponse getAllRentals()
    {
        return service.getAllRentals();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Rental> getOneRental(@PathVariable Integer id)
    {
        return ResponseEntity.ok(service.getOneRental(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StringResponse> update(@RequestParam("name") String name, @RequestParam("price") Double price, @RequestParam("surface") Double surface, @RequestParam("description") String description, @PathVariable int id)
    {
        Optional<Rental> optionalRental = rentalRepository.findById(id);
        
        Rental updatedRental = optionalRental.get();
        updatedRental.setName(name);
        updatedRental.setPrice(price);
        updatedRental.setDescription(description);
        updatedRental.setSurface(surface);
        rentalRepository.save(updatedRental);

        return ResponseEntity.ok(new StringResponse("Rental Updated"));
    }
    
}
