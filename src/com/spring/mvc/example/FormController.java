package com.spring.mvc.example;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.example.datatype.SearchUser;
import com.spring.mvc.example.validator.UserDataValidator;

@Controller 
public class FormController {
	
	@Autowired
	UserDataValidator userDataValidator;
	
	
	@InitBinder
	public void setupBinder(WebDataBinder binder) {
	    binder.setValidator(userDataValidator);
	    
	}
	
	
	@RequestMapping("/searchUser")	
	public String getSearchUserForm(Model model)
	{
		
		model.addAttribute("searchUserObject", new SearchUser());
		return "searchUserForm";
	}

	@RequestMapping("/getUserDetails")	
	public String searchUser(Model model, @Valid SearchUser searchUserObject, BindingResult results)
	{
		System.out.println(searchUserObject.getUserid());
	
		if(results.hasErrors())
			{
			 for(ObjectError errorObject : results.getAllErrors())
			 {
				 System.out.println("Error:" + errorObject.getCode() + "::" + errorObject.getDefaultMessage());
			 }
		
	
			}
		model.addAttribute("searchUserObject", searchUserObject);
		
		return "searchUserResult";
	}
	
	
	
}
