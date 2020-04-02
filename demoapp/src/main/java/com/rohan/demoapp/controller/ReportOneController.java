package com.rohan.demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.demoapp.dao.ReportOneRepository;
import com.rohan.demoapp.utils.EntityManagerUtils;

@RestController
public class ReportOneController {
	
	@Autowired
	ReportOneRepository repository;
	
	@Autowired 
	private EntityManagerUtils emUtils;
	
	
	@GetMapping(value="/report1")
	public List<Object> getAllReportOneData()
	{
		setRepository(3);
		List<Object> reportOneAllObjects = repository.getDataGroupByInfo();
		return reportOneAllObjects;
	}
	
	private void setRepository(int id){
        repository = emUtils.getJpaFactory(id).getRepository(ReportOneRepository.class);
    }
}
