package com.upgrad.backend.ETE.controller;

import com.upgrad.backend.ETE.Model.Employee;
import com.upgrad.backend.ETE.Repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
public class homeController {
    @Autowired

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String Name() {
        return "index.html";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/Profile")
    public String myName() {
        return "index.html";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/Info")
    public String dash() {
        return "dashboard.html";
    }

}

