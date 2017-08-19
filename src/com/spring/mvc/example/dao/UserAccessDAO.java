package com.spring.mvc.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.mvc.example.datatype.UserData;

@Component
public class UserAccessDAO {

	//JdbcTemplate jdbcTemplate ;
	
	NamedParameterJdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(getClass());
    
    
	public void setDataSource(DataSource dataSource )
	{
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	

	public List <UserData> getUserList(String userid)
	{
		System.out.println("userid:" + userid);
		
		MapSqlParameterSource mapSrc = new MapSqlParameterSource("userid","%" + userid + "%");
		
		return this.jdbcTemplate.query("select userid, firstname, LASTNAME ,email from AMDD_USER where userid like :userid", mapSrc, new RowMapper<UserData>() {
			
			@Override
			public UserData mapRow(ResultSet rs, int rowNumber) throws SQLException {
				// TODO Auto-generated method stub
				UserData currentRow = new UserData();
				
				currentRow.setUserid(rs.getString(1));
				currentRow.setFirstname(rs.getString(2));
				currentRow.setLastname(rs.getString(3));
				currentRow.setEmail(rs.getString(4));
				System.out.println(currentRow.toString());
				return currentRow;
			}
			
			
		} ); 
		
		
		
	}
	
}
