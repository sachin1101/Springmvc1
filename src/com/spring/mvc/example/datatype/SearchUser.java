package com.spring.mvc.example.datatype;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SearchUser {
	
	@Size(min =3, max=20 ,message="Incorrect Username")
	@NotNull
	String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	

}
