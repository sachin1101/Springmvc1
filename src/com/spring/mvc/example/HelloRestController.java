package com.spring.mvc.example;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.example.datatype.UserData;
import com.spring.mvc.example.service.UserDetailsService;


@Controller
@RequestMapping("/helloRest")
public class HelloRestController {
	
	
	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(value="/{msg}/aa/{varname}" , method =RequestMethod.GET)
		public String helloWorldRest(@PathVariable String msg, @PathVariable String varname,  Model model)	{
		System.out.println("here1221");
		model.addAttribute("msg", msg);
		model.addAttribute("varname", varname);
		try {
		
			
			List <UserData>userDetailsList=userDetailsService.getUserDetails(varname); 
			model.addAttribute("userDataList", userDetailsList);
		}catch(Exception e)
		{
			
			
		  System.out.println("==");
		  e.printStackTrace(System.out);
		  System.out.println("==");
		}
		
		return "helloWRest";
	}

}
