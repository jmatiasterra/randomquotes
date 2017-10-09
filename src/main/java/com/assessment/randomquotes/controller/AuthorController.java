/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assessment.randomquotes.model.Author;
import com.assessment.randomquotes.services.AuthorService;

/**
 * @author jm
 *
 */
@Controller
@RequestMapping(value="/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public List<Author> getAllAuthors() {
		return service.findAllAuthors();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public Author getAuthor(@PathVariable("id") Long id){		
		return service.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)	
	@ResponseStatus(value=HttpStatus.CREATED)
	@ResponseBody
	public Long createAuthor(@RequestBody Author author){		
		return service.createAuthor(author);
	}
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody void deleteAuthor(@PathVariable("id") Long id){
		service.deleteAuthorById(id);
	}
	//this could be no content
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public void updateAuthor(@PathVariable("id") Long id, @RequestBody Author author){
		Author saveAuthor = service.findById(id);
		if (saveAuthor != null){
			service.updateAuthor(author);
		} else{ // im not sure porque en realidad no existe le chabon
			service.createAuthor(author);
		}
	}

}
