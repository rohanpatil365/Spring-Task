package com.rohan.demoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rohan.demoapp.dao.UserRepository;
import com.rohan.demoapp.entity.Cred;
import com.rohan.demoapp.entity.User;



@Controller
public class MainUserController {

	private final UserRepository userRepository;

	@Autowired
	public MainUserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users/signup")
	public String showSignUpForm(User user) {
		return "add-user_main";
	}

	@GetMapping("/")
	public String login(Cred cred) {
		System.out.println("The Credential : "+cred);
		return "login_main";
	}

	@GetMapping("/users/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index_main";
	}
	@GetMapping("/users/home")
	public String showHomePage(Model model) {
		
		return "header_main";
	}
	
	@GetMapping("/users/index2")
	public String showFirstPage(Model model) {
		
		return "firstScreen_main";
	}
	
	
	
	@GetMapping("/users/index")
	public String showIndexPage(Model model) {
		
		return "home1_main";
	}
	@PostMapping("/users/add")
	public String addStudent(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user_main";
		}

		userRepository.save(user);
		return "redirect:list";
	}

	@PostMapping("/users/index2")
	public String authCred(@Valid Cred cred, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login_main";
		}

		if (cred.getUsername().equals("Admin") && cred.getPassword().equals("Admin"))
			return "redirect:index2";
		else
			return "loginFailed_main";
	}

	@GetMapping("/users/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);
		return "update-user_main";
	}

	@PostMapping("/users/update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user_main";
		}

		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index_main";
	}

	@GetMapping("/users/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		model.addAttribute("users", userRepository.findAll());
		return "index_main";
	}
}
