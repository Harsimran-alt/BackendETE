package com.upgrad.backend.ETE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upgrad.backend.ETE.exception.ResourceNotFoundException;
import com.upgrad.backend.ETE.Model.Employee;
import com.upgrad.backend.ETE.Repository.EmployeeRepository;
import com.upgrad.backend.ETE.services.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    public Services userService;

    @RequestMapping(value = "/addUser",method =RequestMethod.POST)
    public String adduser(@RequestBody String data) throws JsonProcessingException {
        System.out.println(data);
        Employee user = new ObjectMapper().readValue(data, Employee.class);
        System.out.println(user.toString());
        if(userService.adduser(user))
        {
            System.out.println("yes");
            return "true";
        }
        System.out.println("no");
        return "false";
    }

    @RequestMapping("/allusers")
    public List<Employee> getusers()  {
        List<Employee> userList=userService.getallusers();
        System.out.println(userList);
        return userList;
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public void deleteuser(@RequestBody String email)
    {
        System.out.println(email);
        userService.deleteuser(email);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public void update(@RequestBody String data) throws JsonProcessingException {
        System.out.println(data);
        Employee user = new ObjectMapper().readValue(data, Employee.class);
        System.out.println(user.toString());

        userService.adduser(user);





    }
}
