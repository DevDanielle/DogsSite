package edu.missouristate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.missouristate.dao.DogsRepository;
import edu.missouristate.model.Dogs;

@Service ("dogsService")
public class DogsService {
	
	@Autowired
	DogsRepository dogsRepository;

	public List<Dogs> getDogs() {
		return dogsRepository.getDogs();
	}

	public void updateDogs(Model model, Dogs dogs) {
		// TODO Auto-generated method stub
		dogsRepository.updateDogs(dogs);
		
	}

	public void addDogs(Model model, Dogs dogs) {
		// TODO Auto-generated method stub
		dogsRepository.addDogs(dogs);
		
	}

	public int deleteDogs(int id) {
		// TODO Auto-generated method stub
		return dogsRepository.deleteDogs(id);
	
	}

	public void prepareAddDogs(Model model) {
		// TODO Auto-generated method stub
		Dogs dogs = new Dogs();
		model.addAttribute("command", dogs);
		model.addAttribute("title", "Add Dog Entry");
		
	}

	public void prepareEditDogs(Model model, Integer id) {
		// TODO Auto-generated method stub
		Dogs dogs = dogsRepository.getDogById(id);
		model.addAttribute("command", dogs);
		model.addAttribute("title", "Add Dog Entry");
		
	}

	
}
