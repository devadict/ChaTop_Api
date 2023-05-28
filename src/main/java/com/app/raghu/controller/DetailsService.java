package com.app.raghu.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.User;
import com.app.raghu.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@Service
public class DetailsService {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
	public ResponseEntity<User> me(Principal p) {
		String username = p.getName();

		User user = userRepository.findByUsername(username).get();
		int userId = user.getId();

		return ResponseEntity.ok(user);
	}

    @GetMapping("/{id}")
	public ResponseEntity<Integer> me(@PathVariable Integer id) {

		Integer user = userRepository.findById(id).get().getId();
		

		return ResponseEntity.ok(user);
	}
}
