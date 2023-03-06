package com.reviewanalysis.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reviewanalysis.entity.User;
import com.reviewanalysis.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public User insertUser(User user) throws Exception {
		User savedUser = userRepository.save(user); // Note : save() is already implemented by Spring Data JPA
			return savedUser;
	}
	@Override
	public User changePassword(User user) throws Exception {
			User savedPassword=userRepository.save(user);
			return savedPassword;
	}

}
