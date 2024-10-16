package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DoctorLogin;
import com.example.demo.repository.DoctorLoginRepository;

@Service
public class DoctorLoginService {

    @Autowired
    private DoctorLoginRepository doctorLoginRepository;

    public boolean authenticate(String username, String password) {
        DoctorLogin doctor = doctorLoginRepository.findById(username).orElse(null);
        return doctor != null && doctor.getPassword().equals(password);
    }
}
