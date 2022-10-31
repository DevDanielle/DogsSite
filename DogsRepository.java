package edu.missouristate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.missouristate.model.Dogs;
import edu.missouristate.util.MSU;



@Repository
public class DogsRepository {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Dogs> getDogs() {
		//Build a class called MSU.java
		//Build your bean property road mapper
		//Or you could build it at the top of this class
		String sql = "SELECT * from dogs" ;
		return template.query(sql, MSU.DOGS_BPRM);
	}

	
	public void updateDogs(Dogs dogs) {
		String sql = "UPDATE DOGS " + 
                     "   SET breed = ?, " +
                     "       name = ? " +
                     " WHERE id = ? ";

		Object[] args = {dogs.getBreed(), dogs.getName(), dogs.getId()};
		template.update(sql, args);
	}


	public void addDogs(Dogs dogs) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO DOGS (breed, name) " + 
                	 "VALUES (?, ?)";

		Object[] args = {dogs.getBreed(), dogs.getName()};
		template.update(sql, args);
		
	}


	public int deleteDogs(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM dogs " + 
                " WHERE id = ? ";

		Object[] args = {id};
		return template.update(sql, args);
	}


	public Dogs getDogById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * " + 
                "  FROM dogs " +
			     " WHERE id = ? ";

		Object[] args = {id};
		Dogs dogs = template.queryForObject(sql, args, MSU.DOGS_BPRM);		
		return dogs;
		
	}
	
//	public void updateDogs(Dogs dogs) {
//		
//		String sql = "UPDATE USERS " + 
//            "   SET first_name = ?, " +
//            "       last_name = ? " +
//            " WHERE id = ? ";
//
//		Object[] args = {user.getFirstName(), user.getLastName(), user.getId()};
//		template.update(sql, args);
//	}

}
