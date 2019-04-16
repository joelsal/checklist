package com.example.checklist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.checklist.domain.Entry;
import com.example.checklist.domain.EntryRepository;
import com.example.checklist.domain.ImportanceRepository;

@Controller
public class ChecklistController {
	
	@Autowired						//EntryRepository injection
	private EntryRepository erepo;
	
	@Autowired						//ImportanceRepository injection
	private ImportanceRepository irepo;
	
	//Checklist page
	@RequestMapping(value = "/checklist")	//End point for checklist template
	public String checklist(Model model) {
		model.addAttribute("entries", erepo.findAll());	//All entries are fetched from the database and added to the model attribute
		return "checklist";		//Returns the checklist page with all entries fetched from database
	}
	
	//Add new task
	@RequestMapping(value = "/add")			//End point for addentry template
	public String addEntry(Model model) {
		model.addAttribute("entry", new Entry());	//New entry is added to the model attribute
		model.addAttribute("importances", irepo.findAll());	//New importance state is added to the model attribute
		return "addentry";
	}
	
	//Save task
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Entry entry) {
		erepo.save(entry);				//New entry is saved to the repository
		return "redirect:checklist";	//After new entry is saved, redirect to main checklist page
	}
	
	//Delete task
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEntry(@PathVariable("id") Long entryId, Model model) {	//Deletes entry by using its ID
		erepo.deleteById(entryId);						//Entry is deleted from the entryrepository
		return "redirect:../checklist";				//After deletion, redirect to main checklist page
	}
	
	//Edit task
	@RequestMapping(value = "/edit/{id}")
	public String addEntry(@PathVariable("id") long entryId, Model model) {
		model.addAttribute("entry", erepo.findById(entryId)); //The entry is fetched using its ID and then added to the model attribute
		model.addAttribute("importances", irepo.findAll()); //Importance state is added to the model attribute
		return "editentry";	//Returns editentry templace
	}

}
