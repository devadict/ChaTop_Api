package com.app.raghu.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="app_user_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Schema(description = "User Identifier", example = "1")
	@Id
	@GeneratedValue
	private Integer id;

	@Schema(description = "Name of the user", example = "Kylian")
	private String name;

	@Schema(description = "Email of the user", example = "kylian@france.com")
	private String email;

	@Schema(description = "Email of the user", example = "kylian@france.com")
	private String username;

	@Schema(description = "Password of the user", example = "newpass123")
	private String password;

	@Schema(description = "First time user was created", example = "2023-04-06T15:33:45")
	@CreationTimestamp
	private LocalDateTime created_at;
	
	@Schema(description = "Last time informations were modified", example = "2023-04-06T15:33:45")
	@LastModifiedDate
	private LocalDateTime updated_at;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

}
