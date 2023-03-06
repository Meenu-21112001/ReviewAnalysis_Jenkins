package com.reviewanalysis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewanalysis.entity.Profile;
import com.reviewanalysis.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	private final Logger mylogs =LoggerFactory.getLogger(this.getClass());
	 
	@PostMapping("/addreview")  // localhost:8090/profile/addreview
	public ResponseEntity<String> addProfile(@RequestBody Profile profile)
	{
	try 
	{
	Profile savedProfile = profileService.addProfile(profile);
	String responseMsg="saved" +savedProfile.getFirstName() + "Successfully";
	mylogs.info("A value is added ");
	return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	}
	catch(Exception e) 
	{
	String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:- bookstore@gmail.com \n "+e ;
	return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);	 
	}
	}
	@PutMapping("/update/{profileId}")   //localhost:8090/profile/update/{}
	public Profile updateProfile(@RequestBody Profile profile) throws Exception
	{
	return profileService.updateProfile(profile);
	}
	
	@DeleteMapping("/delete/{profileId}")// localhost:8090/profile/delete/{profileId}
    public String deleteAdmin(@PathVariable int profileId) throws Exception
    {
            profileService.deleteProfileById(profileId);
            return "deleted Successfully";
    
    }
	@GetMapping("/allProfile")      // localhost:8090/profile/allProfile
    public List<Profile> getAllProfile()
    {
        try {
            List<Profile> allprofile = profileService.getAllProfile();
            return allprofile;
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}



