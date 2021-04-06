package com.wallet.service;

import java.util.Optional;

import com.wallet.entity.User;

public interface UserService {
	
	public Optional<User> findByEmail(String email);
	
}
