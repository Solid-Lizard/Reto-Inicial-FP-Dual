package com.nttdata.retoinicial.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.services.LanguageManagementServiceI;


@RestController
@RequestMapping("/rest")
public class CrudRestController {
	// ATRIBUTOS //
	@Autowired
	private LanguageManagementServiceI languageService;

	// MÉTODOS //
	
	// CRUD //
	
	// Create //
	@PostMapping("/languages")
	public Language newLanguage(@RequestBody Language l) {
		languageService.create(l);
		return l;
	}
	
	// Read //
	@GetMapping("/languages")
	public List<Language> all() {
		return languageService.searchAll();
	}
	
	@GetMapping("/searchById/{id}")
	public Language findById(@PathVariable int id) {
		return languageService.searchById(id);
	}
	
	// Update //
	@PutMapping("/updateLanguage/{id}")
	public Language updateLanguage(@RequestBody Language l,
			@PathVariable int id) {
		
		
		Language l2 = languageService.searchById(id);
		
		if (l2 != null) {
			l2.setName(l.getName());
			l2.setMessage(l.getMessage());
			
			languageService.update(l2);
			
		} else {
			l.setId(id);
			languageService.create(l2);
			
		}
		
		return l;
		
	}
	
	// Delete //
	@DeleteMapping("/deleteLanguage/{id}")
	public void deleteLanguage(@PathVariable int id) {
		Language l = languageService.searchById(id);
		languageService.delete(l);
	}
	
}
