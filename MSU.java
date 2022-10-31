package edu.missouristate.util;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import edu.missouristate.model.Dogs;

public class MSU {
	
	public static final BeanPropertyRowMapper<Dogs> DOGS_BPRM = 
			new BeanPropertyRowMapper<Dogs>(Dogs.class);


	
}
