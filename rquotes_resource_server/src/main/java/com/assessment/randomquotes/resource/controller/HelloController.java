/**
 * 
 */
package com.assessment.randomquotes.resource.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jm
 *
 */
@Controller
public class HelloController {

	private static final Logger logger = Logger.getLogger(HelloController.class);

	@GetMapping("/hello")
	public String hello(Model model) {
		logger.info("logging");
		model.addAttribute("name", "Alvarito");

		return "welcome";
	}

}
