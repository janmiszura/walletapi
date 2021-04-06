package com.wallet.controller;

import javax.validation.constraints.Email;

import com.wallet.entity.User;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	
	private String name;
	
	@Email(message = "E-mail inválido")
	private String email;

	private String password;
	
	public User toUser() {
		User u = new User();
		
		u.setEmail(email);
		
		u.setName(name);
		
		u.setId(id);
		
		u.setPassword(password);
		
		return u;
	}

	public static UserDTO fromUser(User user) {
		
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		
		dto.setName(user.getName());
		
		dto.setId(user.getId());
		
		dto.setPassword(user.getPassword());
		
		return dto;
	}
	
}