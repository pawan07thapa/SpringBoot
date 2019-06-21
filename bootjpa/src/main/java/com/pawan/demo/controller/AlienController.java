package com.pawan.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pawan.demo.dao.AlienRepo;
import com.pawan.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired // no tight coupling
	AlienRepo repo; // TO SAVE DATA ENTERED TO DATABASE

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject(alien);
//		mv.setViewName("display.jsp");
		repo.save(alien);
		return "";

	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		mv.setViewName("ShowAlien.jsp");

		// USING CRUD REPO
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(3));
		System.out.println(repo.findByTechSorted("Java"));

//		return "ShowAlien.jsp";  // Shows the "ShowAlien.jsp" page with no data
		return mv; // returns the alien object to "ShowAlien.jsp"
	}

	@RequestMapping("/delAlien")
	public String deleteAlien(@RequestParam int aid) {
		Alien alien = repo.findById(aid).orElse(null);
		repo.delete(alien);
		// repo.save();
		return "home.jsp";
	}

	@RequestMapping("/alien")
	@ResponseBody
	/**
	 * BY DEFAULT THE RETURN TYPE MEANS A VIEW i.e. HOME.JSP SHOWALIEN.JSP BUT IN
	 * REST WE WANT TO RETURN DIRECTLY THE DATA AND ALL THE DATA IS IN STRING FORMAT
	 * ONLY THEREFORE IN ORDER TO TELL THAT WE ARE RETURNING DATA AND NOT VIEW WE
	 * NEED TO SPECIFY THE ANNOTATION @ResponseBody
	 **/
	public List<Alien> getAlien() {
		return repo.findAll();

	}

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	/**
	 * PATH VARIABLE TELLS THAT WHATEVER VALUE IS COMING IN WILDCARD {aid} DURING
	 * REQUEST MAPPING IS ASSIGNED TO THE INT VARIABLE aid IN FUNCTION CALLING
	 **/
	public Optional<Alien> findAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);

	}
	/**
	 * HERE WE WERE SIMPLY FETCHING DATA , BUT WE ALSO NEED TO WRITE DATA THE DATA
	 * THAT WE SHOULD RETURN SHOULD BE IN JSON OR XML FORMAT , ELSE HOW WILL ANOTHER
	 * SERVICE UNDERSTAND WHAT WE ARE SENDING OR FETCHING. WE NEED TO CONVERT OUR
	 * RESPONSE IN JSON FORMAT.
	 * WE ALSO WANT TO PERFORM DELETE AND UPDATE AND WE WILL DO THIS WITH THE 
	 * HELP OF A CLIENT CALLED POSTMAN
	 **/
}
