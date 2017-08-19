package com.spring.mvc.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.mvc.example.dao.UserAccessDAO;
import com.spring.mvc.example.datatype.UserData;

@Component("userDetailsService")
public class UserDetailsService {


	@Autowired
	private UserAccessDAO userAccessDAO; 
	

	

	public UserAccessDAO getUserAccessDAO() {
		return userAccessDAO;
	}

	public void setUserAccessDAO(UserAccessDAO userAccessDAO) {
		this.userAccessDAO = userAccessDAO;
	}
	
	public List<UserData>  getUserDetails(String userid)
	{
		return this.userAccessDAO.getUserList(userid);
	}
	
}
