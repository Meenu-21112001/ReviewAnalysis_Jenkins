package com.reviewanalysis.service;

//import java.util.List;

import org.springframework.stereotype.Service;

import com.reviewanalysis.entity.Profile;
import com.reviewanalysis.entity.User;

@Service
public interface UserService 
{
    public User insertUser(User user)throws Exception;
    public User changePassword(User user)throws Exception;
}
