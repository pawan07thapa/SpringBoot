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

import com.pawan.demo.dao.AlienRepo;
import com.pawan.demo.model.Alien;

@RestController /**
				 * not Controller , all the methods now will be working for REST , WE CAN ALSO
				 * REMOVE @ResponseBody now
				 **/
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

	/**
	 * ALL THE REQUESTS THAT ARE COMING FROM POSTMAN i.e. GET POST PUT DELETE their
	 * actions need to be written here
	 * , produces = { "application/xml" } -> implies that only xml data will be accepted
	 * and to be written in Annotation @ReqeustMapping 
	 **/

	@RequestMapping(path = "/alien") // only supports xml ie returns the data in xml
																		// format only

	/**
	 * -> INSTEAD OF REQUEST MAPPING WE CAN ALSO USE GET MAPPING ->BY DEFAULT THE
	 * RETURN TYPE MEANS A VIEW i.e. HOME.JSP SHOWALIEN.JSP BUT IN REST WE WANT TO
	 * RETURN DIRECTLY THE DATA AND ALL THE DATA IS IN STRING FORMAT ONLY THEREFORE
	 * IN ORDER TO TELL THAT WE ARE RETURNING DATA AND NOT VIEW WE NEED TO SPECIFY
	 * THE ANNOTATION @ResponseBody
	 **/
	public List<Alien> getAlien() {
		return repo.findAll();

	}

	@RequestMapping("/alien/{aid}")

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
	 * RESPONSE IN JSON FORMAT. WE ALSO WANT TO PERFORM DELETE AND UPDATE AND WE
	 * WILL DO THIS WITH THE HELP OF A CLIENT CALLED POSTMAN
	 *  **/

	/**
	 * CONTENT NEGOTIATION If the client says i want a xml format then server says i
	 * dont have a xml , and if it asks for json it will give it json this is called
	 * content negotiation
	 **/
	@PostMapping("/alien")
	// TO ENABLE RAW DATA FORMAT WE NEED TO USE ANNOTATION REQUESTBODY
	public Alien addAlien1(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien1(@PathVariable("aid") int aid)
	{
		repo.deleteById(aid);
		return "Deleted";
	}
	
	@PutMapping(path="/alien " )
	public String saveOrUpdate(@RequestBody Alien alien)
	{
		repo.save(alien);
		return "Updated";
	}
	
}
