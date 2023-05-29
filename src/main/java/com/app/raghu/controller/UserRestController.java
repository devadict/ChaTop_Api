package com.app.raghu.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.dto.request.LoginRequest;
import com.app.raghu.entity.User;
import com.app.raghu.entity.UserRequest;
import com.app.raghu.entity.UserResponse;
import com.app.raghu.repository.UserRepository;
import com.app.raghu.service.IUserService;
import com.app.raghu.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@Service
public class UserRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IUserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<UserResponse> saveUser(@RequestBody User user) {
		User userExists = service.findByUsername(user.getUsername());
		
		if (userExists != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} 
		Integer id = service.saveUser(user);

		String token = jwtUtil.generateToken(user.getUsername());
		

		return ResponseEntity.ok(new UserResponse(token));
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest)
	{

		String username = userRequest.getEmail();
		try {

			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					username, 
					userRequest.getPassword()
				)
			);
		} catch (AuthenticationException e)  {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		String token = jwtUtil.generateToken(username);
		

		return ResponseEntity.ok(new UserResponse(token));
	}
	
	@PostMapping("/welcome")
	public ResponseEntity<String> accessUserData(Principal p) {

		return ResponseEntity.ok("Hello user:" + p.getName());
	}
	
	@GetMapping("/me")
	public ResponseEntity<User> me(Principal p) {
		String username = p.getName();

		User user = userRepository.findByUsername(username).get();
		int userId = user.getId();

		return ResponseEntity.ok(user);
	}
}
