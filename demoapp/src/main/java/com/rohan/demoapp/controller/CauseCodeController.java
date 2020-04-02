package com.rohan.demoapp.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.demoapp.service.CauseCodeService;

@RestController
public class CauseCodeController {
	
	private ArrayList<Map<String,Object>> dataResponse = null;
	private Map<String,Object> response = null;
	
	@Autowired
	private CauseCodeService causeCodeService;
	
	/*
	@GetMapping(value = "/cc_report/{account}")
	public ArrayList<Map<String,Object>> getCauseCodeCount(@PathVariable(value = "account") String account)
	{
		dataResponse = causeCodeService.getCauseCodeCount(account);
		return dataResponse;
	}
	*/
	
	@GetMapping(value = "/cc_report/{account}")
	public Map<String,Object> getCCCount(@PathVariable(value = "account") String account)
	{
		response = causeCodeService.getCCCount(account);
		return response;
	}
	
}
