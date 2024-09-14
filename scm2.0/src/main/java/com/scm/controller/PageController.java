package com.scm.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

import org.springframework.ui.Model;


@Controller
public class PageController {
	
	@Autowired
	private UserService userService;
     
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
	 
	 //login
	 @RequestMapping("/login")
	 public String loginPage() {
		 System.out.println("Login page loading");
		 return "login";
	 }
	 
	 //register
	 @RequestMapping("/register")
	 public String registerPage(Model model) {
		 
		 UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		 //System.out.println("Register page loading");
		 return "register";
	 }
	 
	 //processing register
	 
	 @RequestMapping(value="/do-register", method=RequestMethod.POST)
     public String processRegister(@ModelAttribute UserForm userForm) {
		 System.out.println("Processing registration");
		 //fetch form data
		 //User form
		 System.out.println(userForm);
		 
		 //validate form data
		 //TODO::validate userForm
		 
		 //save to database
		 
		 //user service
		 //retrieve data from UserForm --> User
//		 User user = User.builder()
//		 .name(userForm.getName())
//		 .email(userForm.getEmail())
//		 .password(userForm.getPassword())
//		 .about(userForm.getAbout())
//		 .phoneNumber(userForm.getPhoneNumber())
//		 .profilePic("https://photos.google.com/photo/AF1QipM1glC9I2cl1Tt2MdTLzzW8aVGKnJsnMadlHbL7")
//		 .build();
		 
		 User user = new User();
		 user.setName(userForm.getName());
		 user.setEmail(userForm.getEmail());
		 user.setPassword(userForm.getPassword());
		 user.setAbout(userForm.getAbout());
		 user.setPhoneNumber(userForm.getPhoneNumber());
		 user.setProfilePic("https://photos.google.com/photo/AF1QipMswF4he-WOxFqKAThlZdy-tl5lW-5Ld9nBDSr5");
		 
		 User savedUser = userService.saveUser(user);
		 
		 System.out.println("user saved");
		 
		 //message("Registration successful")
		 
		 //redirect to login page
    	 return "redirect:/login";
     }
	 
	 //contact
	 @RequestMapping("/contact")
	 public String contactPage() {
		 System.out.println("Contact us page loading");
		 return "contact";
	 }
	 
	 
}

