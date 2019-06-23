package com.pawan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pawan.demo.dao.Repo;
import com.pawan.demo.model.Customer;

@Controller
public class HomeController {

	@Autowired
	Repo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addCustomer")
	public String Register(Customer customer) {
		repo.save(customer);
		return "AddedSuccessfully.jsp";
	}

	@RequestMapping("/cusLogin")
	public String login( String cName,  String cPassword) {
		if (repo.existsBycName(cName)) {
			Customer cus = repo.findBycName(cName);
			
			if (cus.getPassword().equals(cPassword)) {
				return "displayCustomers.jsp";
			}
			return "PasswordMismatch.jsp";
		} else
			return "home.jsp";
	}

}
