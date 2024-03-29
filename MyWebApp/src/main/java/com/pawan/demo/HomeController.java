package com.pawan.demo;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
/**	@RequestMapping("home") // DISPATCHER SERVLET RUNS BEHIND THE SCENE , WE DONT HAVE TO DO THAT NO WEB.XML FILE
	//@ResponseBody
	public String home(HttpServletRequest req) 
	{	// NO NEED TO CREATE A RESPONSE OBJECT HERE ...SB AUTOCONFIGURES
		HttpSession session = req.getSession();

		String name=req.getParameter("name");  // GET THE CLIENTS DATA
		System.out.println("hi "+ name);
		session.setAttribute("name" , name);
		return "home";
		//return;
	}

	
//	WORKING WITH MODEL AND VIEW
	@RequestMapping("home")
	// NAME IS THE DATA FROM CLIENT SIDE , WE READ IT AS MYNAME USING REQUESTPARAM ANNOTATION
	public ModelAndView home(@RequestParam("name") String Myname ) 
	{
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("name", Myname); // DATA IS SEND IN THE FORM OF A MODEL
		mv.setViewName("home");// AND THE RECIEVED DATA IS VIEWED IN A VIEW  
		//sess.setAttribute("name" , Myname);  // this much would work sess does dependency injection and creates a Httpsession object
		return mv;
		//return;
	}
  **/
	@RequestMapping("home")
	//WHEN THERE ARE MULTIPLE PROPERTIES TO BE SET IT WOULD BE BETTER TO USE AN OBJECT AND PASS THAT OBJECT
	public ModelAndView home(Alien alien ) 
	{
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("obj", alien); // DATA IS SEND IN THE FORM OF A MODEL
		mv.setViewName("home");// AND THE RECIEVED DATA IS VIEWED IN A VIEW  
		//sess.setAttribute("name" , Myname);  // this much would work sess does dependency injection and creates a Httpsession object
		return mv;
		//return;
	}
	
		
}
