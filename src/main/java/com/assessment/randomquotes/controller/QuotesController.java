/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assessment.randomquotes.model.Quote;

/**
 * @author matias.terracciano
 *
 */
@Controller
public class QuotesController {

	@RequestMapping(value = "/quotes", method = RequestMethod.GET)
	@ResponseBody
	public List<Quote> getAllQuotes() {
		// TODO change this for a service
		return generateQuotes();
	}
	
	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Quote getQuote(@PathVariable("id") Long id){		
		return new Quote();
	}
	
	@RequestMapping(value = "/quotes", method = RequestMethod.POST)	
	@ResponseStatus(value=HttpStatus.CREATED)
	public @ResponseBody void createQuote(){		
		//TODO
	}
	
	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public @ResponseBody Quote updateQuote(@PathVariable("id") Long id, @RequestBody Quote quote){
		System.out.println(quote.getText());
		// TODO save modification an return an element
		return new Quote();
	}
	
	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)	
	public @ResponseBody void deleteQuote(@PathVariable("id") Long id){		
		// TODO save modification an return an element
		//call service an return status code
	}
	

	private List<Quote> generateQuotes() {
		List<Quote> quotes = new ArrayList<Quote>();
		List<String> tags = new ArrayList<String>();
		tags.add("figuras populares");
		tags.add("ciencia");
		Quote quote = new Quote();
		quotes.add(quote);
		return quotes;

	}

}
