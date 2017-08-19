package com.spring.mvc.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.mvc.example.datatype.SearchUser;

@Component
public class UserDataValidator implements Validator{

	@Override
	public boolean supports(Class<?> classType) {
		// TODO Auto-generated method stub
		
		return SearchUser.class.isAssignableFrom(classType);

		
	}

	@Override
	public void validate(Object inputObject, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userid", "userid required");
		
		SearchUser userData = (SearchUser)inputObject;
		System.out.println("Inside validator");
		
		
		if(userData.getUserid().equals("test"))
		{
			System.out.println("Validator::" + userData.getUserid());
		}
		
	}

}
