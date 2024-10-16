package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.HospitalLoginService;

@Controller
@RequestMapping ("/hospital")
public class HospitalController {
	
	@Autowired
    private HospitalLoginService hospitalLoginService;

	   @GetMapping("/login")
	   public String showHospitalLoginPage() {
	        return "hospitalLogin"; // Renders the hospitalLogin.jsp
	    }
	   
	   @PostMapping("/login")
	    public ModelAndView performLogin(@RequestParam("username") String username,
	                                     @RequestParam("password") String password) {
	        ModelAndView modelAndView = new ModelAndView();
	        boolean isAuthenticated = hospitalLoginService.authenticate(username, password);
	        if (isAuthenticated) {
	            modelAndView.setViewName("hospitalDashboard"); // Redirect to hospital dashboard
	        } else {
	            modelAndView.setViewName("hospitalLogin"); // Back to login page with error
	            modelAndView.addObject("error", "Invalid Credentials!");
	        }
	        return modelAndView;
	    }
	}


