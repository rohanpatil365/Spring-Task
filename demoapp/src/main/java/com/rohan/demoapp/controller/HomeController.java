package com.rohan.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String showIndexPage() {
        return "index";
    }
	
	@GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
	
	@GetMapping("/report/ccreport")	
	public String showCauseCodeReport() {
        return "causeCodeReport";
    }
	
}
