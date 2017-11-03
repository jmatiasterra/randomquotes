/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	public List<QuoteDTO> getAllQuotes() {
		return service.findAllQuotes();
	}

}
