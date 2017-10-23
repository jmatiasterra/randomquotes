/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assessment.randomquotes.model.Quote;
import com.assessment.randomquotes.model.QuoteDTO;
import com.assessment.randomquotes.services.QuoteService;

/**
 * @author matias.terracciano
 *
 */
@Controller
public class QuoteController {

	@Autowired
	private QuoteService service;

	@RequestMapping(value = "/quotes/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Quote> getAllQuotes() {
		return new ArrayList<Quote>();
	}

	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public QuoteDTO getQuote(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/quotes/", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public Long createQuote(@RequestBody Quote quote) {
		/*
		 * System.out.println(quote.toString()); Author author =
		 * authorService.findById(quote.getAuthor().getId()); quote.setAuthor(author);
		 * return service.createQuote(quote);
		 */
		return new Long(-1);
	}

	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void updateQuote(@PathVariable("id") Long id, @RequestBody QuoteDTO quote) {
		QuoteDTO saveQuote = service.findById(id);
		if (saveQuote != null) {
			service.updateQuote(id, quote);
		}
	}

	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void deleteQuote(@PathVariable("id") Long id) {
		service.deleteQuoteById(id);
	}

	@RequestMapping(value = "/authors/{id}/quotes/", method = RequestMethod.GET)
	@ResponseBody
	public QuoteDTO getQuoteByAuthor(@PathVariable("id") Long id) {
		return service.findById(id);
	}

}
