/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assessment.randomquotes.model.Quotes;

/**
 * @author matias.terracciano
 *
 */
@Controller
public class QuotesController {

	@RequestMapping(value = "/quotes", method = RequestMethod.GET)
	@ResponseBody
	public List<Quotes> getAllQuotes() {
		// TODO change this for a service
		return generateQuotes();
	}
	
	@RequestMapping(value = "/quotes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Quotes getQuote(@PathVariable("id") Long id){		
		return new Quotes();
	}
	
	@RequestMapping(value = "/quotes", method = RequestMethod.POST)
	@ResponseBody
	public void createQuote(){		
		//TODO
	}

	private List<Quotes> generateQuotes() {
		List<Quotes> quotes = new ArrayList<Quotes>();
		List<String> tags = new ArrayList<String>();
		tags.add("figuras populares");
		tags.add("ciencia");
		Quotes quote = new Quotes(
				"Todos somos muy ignorantes, lo que ocurre es que no todos ignoramos las mismas cosas",
				"Albert Einstein", tags);
		quotes.add(quote);
		return quotes;

	}

}
