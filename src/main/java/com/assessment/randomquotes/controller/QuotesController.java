/**
 * 
 */
package com.assessment.randomquotes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assessment.randomquotes.model.Quotes;

/**
 * @author matias.terracciano
 *
 */
@Controller
@RequestMapping("/quotes")
public class QuotesController {

	@RequestMapping(method = RequestMethod.GET)
	public List<Quotes> get() {
		// TODO change this for a service
		return new ArrayList<Quotes>();
	}

	@RequestMapping(path = "/quotes/{tag}", method = RequestMethod.GET)
	public List<Quotes> getByTag(String tag) {
		// TODO change this for a service
		return new ArrayList<Quotes>();
	}

}
