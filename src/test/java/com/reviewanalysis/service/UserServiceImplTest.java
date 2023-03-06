package com.reviewanalysis.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.reviewanalysis.entity.User;
import com.reviewanalysis.repository.UserRepository;
@SpringBootTest
class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserServiceImpl userService;
	
	
	@Test
	@DisplayName("to verify Insert Operation")
	void testInsertUser()  throws Exception
	{
		User sampleInput=new User("meenu","jhuias");
		User expectedOutput=new User("meenu","igsa");
		
		BDDMockito.given(userService.insertUser(sampleInput)).willReturn(expectedOutput);
		
		User actualOutput=userService.insertUser(sampleInput);
		assertEquals(expectedOutput, actualOutput);
	}
}
