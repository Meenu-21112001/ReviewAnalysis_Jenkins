package com.reviewanalysis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewanalysis.entity.User;
import com.reviewanalysis.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	public UserController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}
	private final Logger mylogs =LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/adduser")  //localhost:8090/user/adduser
	public ResponseEntity<String> addUser(@RequestBody  User user) {
		try
		{
			User savedUser = userService.insertUser(user);
			String responseMsg = savedUser.getUserId()+"Saved Successfully";
			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@travel.com"+e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{userId}")   // localhost:8090/profile/update/{}
	public User updatePassword(@RequestBody User user) throws Exception
	{
	return userService.changePassword(user);
	}
	
}