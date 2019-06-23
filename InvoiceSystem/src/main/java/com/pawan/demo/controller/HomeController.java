package com.pawan.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
	public String login(String cName, String cPassword) {
		if (repo.existsBycName(cName)) {
			Customer cus = repo.findBycName(cName);

			if (cus.getPassword().equals(cPassword)) {
				return "displayCustomers.jsp";
			}
			return "PasswordMismatch.jsp";
		} else
			return "home.jsp";
	}

	@RequestMapping("/customer")
	@ResponseBody
	public List<Customer> cusList() {
		return repo.findAll();
	}

	@RequestMapping("/customer/{cId}")
	@ResponseBody
	public Optional<Customer> findCust(@PathVariable("cId") int cid) {
		return repo.findById(cid);
	}

	/**
	 * POST IS USED ONLY TO CREATE AND PUT IS USED BOTH TO CREATE AND
	 * UPDATE @PutMapping("/customer")
	 */
	@PostMapping("/customer")
	@ResponseBody
	public String addCus(@RequestBody Customer cust) {
		repo.save(cust);
		return "Added";
	}

	@DeleteMapping("/customer/{cId}")
	@ResponseBody
	public String delCus(@PathVariable("cId") int cid) {
		repo.deleteById(cid);
		return "Deleted";
	}

	@PutMapping("/customer")
	// TO ENABLE RAW DATA FORMAT WE NEED TO USE ANNOTATION REQUESTBODY
	public String update(@RequestBody Customer cus) {
		repo.save(cus);
		return "updated";
	}
}
