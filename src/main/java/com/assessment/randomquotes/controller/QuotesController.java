/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.randomquotes.model.Quotes;

/**
 * @author matias.terracciano
 *
 */
@RestController
public class QuotesController {

	@RequestMapping(value = "/quotes", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Quotes> get() {
		// TODO change this for a service
		return new ArrayList<Quotes>();
	}

}
