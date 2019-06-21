package com.pawan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pawan.demo.dao.AlienRepo;
import com.pawan.demo.model.Alien;


@Controller
public class AlienController {


@Autowired     //no tight coupling
AlienRepo repo;  //  TO SAVE DATA ENTERED TO DATABASE
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject(alien);
//		mv.setViewName("display.jsp");
		repo.save(alien);
		return "";
		
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv= new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien()); 
		mv.addObject(alien);
		mv.setViewName("ShowAlien.jsp");
		
		//USING CRUD REPO
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(3));
		System.out.println(repo.findByTechSorted("Java"));
		
//		return "ShowAlien.jsp";  // Shows the "ShowAlien.jsp" page with no data
		return mv;          // returns the alien object to "ShowAlien.jsp"
	}
	
	@RequestMapping("/delAlien")
	public String deleteAlien(@RequestParam int aid)
	{	
		Alien alien=repo.findById(aid).orElse(null);
		repo.delete(alien);
		//repo.save();
		return "home.jsp";
	}	
	
	
	
} 
