package com.oded.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oded.dao.RegistrationRepo;
import com.oded.model.LoginModel;
import com.oded.model.UserModel;

@Controller
public class MyController {
	String hashedPassword;
	@Autowired
	private RegistrationRepo repo;

	@GetMapping(value = { "/", "home" })
	public String home() {

		return "welcome";
	}

	@GetMapping("log")
	public String login(@ModelAttribute("login") LoginModel logmodel, Model model, HttpSession session) {
		model.addAttribute("login", new LoginModel());
		return "login";
	}

	@GetMapping("contactus")
	public String contactus() {

		return "contactus";
	}

	@GetMapping("aboutus")
	public String about() {

		return "aboutus";
	}

	@GetMapping("logout")
	public String log(HttpSession session, Model model) {
		String name = (String) session.getAttribute("name");
		System.out.println(name);
		model.addAttribute("name", name);
		session.invalidate();
		return "logout";
	}


	@GetMapping("register")
	public String register(Model model) {

		model.addAttribute("user", new UserModel());

		return "register";

	}
	
	@PostMapping("save")
	public String save(@Valid @ModelAttribute("user") UserModel usermodel, BindingResult br, HttpSession session) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		hashedPassword = passwordEncoder.encode(usermodel.getPassword());
		session.setAttribute("savep",hashedPassword);
		UserModel hashed = new UserModel();
		hashed.setAddress(usermodel.getAddress());
		hashed.setEmail(usermodel.getEmail());
		hashed.setFirstname(usermodel.getFirstname());
		hashed.setPhoneno(usermodel.getPhoneno());
		hashed.setUsername(usermodel.getUsername());
		hashed.setLastname(usermodel.getLastname());
		hashed.setPassword(hashedPassword);
		if (br.hasErrors()) {
			return "register";
		} else {
			UserModel save = repo.save(hashed);
			
			return "success";
		}
	}

	@PostMapping("auth")
	public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) 
	{
		String passwordd=(String) session.getAttribute("savep");
		UserModel data = repo.findUserPassword(username,passwordd);
		session.setAttribute("name", username);
		{
		 if (data != null) {
			return "welcome";
		//}else
		}
		{
		return "error";
		}
	}
	}
}

	
