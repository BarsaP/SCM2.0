package com.scm.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
public class PageController {
     
	//http://localhost:8081/home
	 @RequestMapping(value = "/home", method = RequestMethod.GET)
     public String home(Model model)
     {
        System.out.println("Home page handler");
        //sending data to view
        model.addAttribute("name", "Substring Technology");
        model.addAttribute("youtubeChannel", "Barsa Jena");
        model.addAttribute("githubRepo", "https://github.com/BarsaP");
         return "home";
     }
	 
	 //about
	 @RequestMapping("/about")
	 public String aboutPage() {
		 System.out.println("About page loading");
		 return "about";
	 }
	 
	 //Services
	 @RequestMapping("/services")
	 public String servicePage() {
		 System.out.println("Services page loading");
		 return "services";
	 }
}

