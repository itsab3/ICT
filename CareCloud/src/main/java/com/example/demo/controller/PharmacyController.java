package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PharmacyLoginService;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyController {
	
	@Autowired
	private PharmacyLoginService pharmacyLoginService;

    @GetMapping("/login")
    public String showPharmacyLoginPage() {
        return "pharmacyLogin"; // Renders the pharmacyLogin.jsp
    }
    
    @PostMapping("/login")
    public ModelAndView performLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        boolean isAuthenticated = pharmacyLoginService.authenticate(username, password);
        if (isAuthenticated) {
            modelAndView.setViewName("pharmacyDashboard"); // Redirect to pharmacy dashboard
        } else {
            modelAndView.setViewName("pharmacyLogin"); // Back to login page with error
            modelAndView.addObject("error", "Invalid Credentials!");
        }
        return modelAndView;
    }
}