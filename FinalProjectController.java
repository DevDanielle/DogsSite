package edu.missouristate.controllers;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.missouristate.model.Dogs;
import edu.missouristate.services.DogsService;
import edu.missouristate.util.Helper;

@Controller
public class FinalProjectController {
	
	@Autowired
	DogsService dogsService;
	
	/**
	 * GET MAPPING ROUTE INPUT FOR PROVIDING LIST OF DOGS TO THE END USER
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping(value = "/finalproject")
	public String getFinalProject(Model model, HttpSession session) {
		
		//get all the info from table
		//gets info and adds to jsp
		List<Dogs> dogsList = dogsService.getDogs();
		model.addAttribute("dogsList", dogsList);
		return "dogs";
	}
	
	/**
	 * GET MAPPING
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/finalproject/addEditDogs")
	public String getAddEdit(Model model, String id) {
		
		if (id != null && id.length() > 0) {
			//call service and get instance of dogs
			dogsService.prepareEditDogs(model, Integer.parseInt(id));
			
		} else {
			//no id passed in so create new object
			dogsService.prepareAddDogs(model);
		}
		
		return "addEditDogs";
		
	}
	
	/**
	 * POST MAPPING
	 * @param
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/finalproject/addEditDogs")
	public String getAddEdit(Model model, Dogs dogs) {
		
		//determine if we are adding or updating by looking for an id
		
		if (dogs != null && dogs.getId() != null) {
			//then we have an object to update in db
			dogsService.updateDogs(model, dogs);
			
		} else {
			//we have an object to insert into db
			dogsService.addDogs(model, dogs);
			
		}
		//always want to redirect after a post vs returning a view
		return "redirect:/finalproject";
			
		
	}
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/finalproject/deleteDogs")
	public String getDeleteDogs(HttpSession session, Model model, String id) {
		
		if (Helper.isInteger(id)) {
			int deleteCount = dogsService.deleteDogs(Integer.parseInt(id));
			Helper.addSessionMessage(session, "Records Deleted: " + deleteCount);
			
		} else {
			String idString = ((id == null) ? "''" : ("'" + id + "'"));
			Helper.addSessionMessage(session, "Sorry, could not find dog with id = " + idString);
		}
		return "redirect:/finalproject";
	}
	
}
