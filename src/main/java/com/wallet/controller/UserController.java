package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Response<UserDTO>> save(@Valid @RequestBody UserDTO userDTO) {
		
		Response<UserDTO> response = new Response<>();
		
		User user = userDTO.toUser();
		
		user = userService.save(user);
		
		UserDTO userDtoReturn = UserDTO.fromUser(user);
		
		response.setData(userDtoReturn);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
