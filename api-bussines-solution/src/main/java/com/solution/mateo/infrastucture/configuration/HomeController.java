package com.solution.mateo.infrastucture.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/")
	public String index() {
		logger.info("/swagger-ui/index.html");
		return "redirect:/swagger-ui/index.html";
	}
}