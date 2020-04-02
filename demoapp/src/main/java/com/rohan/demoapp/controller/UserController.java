package com.rohan.demoapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.demoapp.dao.UsersRepository;
import com.rohan.demoapp.entity.UserEntity;
import com.rohan.demoapp.utils.EntityManagerUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	ArrayList<Iterable<UserEntity>> allUserList;
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired 
	private EntityManagerUtils emUtils;
	
	/*
	@RequestMapping(value = "/all")
	public ArrayList<Iterable<UserEntity>> getAllUsers() {
		allUserList = new ArrayList<Iterable<UserEntity>>();
		for(int i=1;i<=3;i++)
		{
			setRepository(i);
			Iterable<UserEntity> userList = repository.findAll();
			allUserList.add(userList);
		}
		return allUserList;
	}
	
	@RequestMapping(value = "/{schema}")
	public Iterable<UserEntity> getAll(@PathVariable(value="schema") String schema) {
		setRepository(Integer.parseInt(schema));
		return repository.findAll();
	}
	*/
	
	
	@RequestMapping(value = "/all")
	public String getAllUsers(Model model) {
		allUserList = new ArrayList<Iterable<UserEntity>>();
		for(int i=0;i<3;i++)
		{
			setRepository(i);
			Iterable<UserEntity> userList = repository.findAll();
			allUserList.add(userList);
		}
		model.addAttribute("userslist", allUserList);
		return "index";
	}
	
	@RequestMapping(value = "/{schema}")
	public String getAll(@PathVariable(value="schema") String schema,Model model) {
		allUserList = new ArrayList<Iterable<UserEntity>>();
		setRepository(Integer.parseInt(schema));
		Iterable<UserEntity> userList = repository.findAll();
		allUserList.add(userList);
		model.addAttribute("userslist", allUserList);
		return "index";
	}
	
	
	
	private void setRepository(int id){
        repository = emUtils.getJpaFactory(id).getRepository(UsersRepository.class);
    }
}
