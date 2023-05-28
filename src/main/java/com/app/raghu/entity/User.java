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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="app_user_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String email;
	private String username;
	private String password;

	@CreationTimestamp
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime updated_at;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

}
