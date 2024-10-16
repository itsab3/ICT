package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DoctorLoginService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
    private DoctorLoginService doctorLoginService;


    @GetMapping("/login")
    public String showDoctorLoginPage() {
        return "doctorLogin"; // Renders the doctorLogin.jsp
    }
    
    @PostMapping("/login")
    public ModelAndView performLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        boolean isAuthenticated = doctorLoginService.authenticate(username, password);
        if (isAuthenticated) {
            modelAndView.setViewName("doctorDashboard"); // Redirect to doctor dashboard
        } else {
            modelAndView.setViewName("doctorLogin"); // Back to login page with error
            modelAndView.addObject("error", "Invalid Credentials!");
        }
        return modelAndView;
    }
}