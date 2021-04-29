package com.upgrad.backend.ETE.services;

import com.upgrad.backend.ETE.Model.Employee;
import com.upgrad.backend.ETE.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Services  {


    @Autowired
    public EmployeeRepository userrepo;

    public boolean adduser(Employee user)
    {

        if(this.userrepo.existsById(user.getEmailId())){
            return false;
        }
        else{
            try {
                this.userrepo.save(user);
            }
            catch (Exception e)
            {
                return false;
            }
            return true;
        }

    }
    public List<Employee> getallusers()
    {


        return (List<Employee>) this.userrepo.findAll();
    }

    public void deleteuser(String email)
    {
        this.userrepo.deleteById(email);
    }

    public void update(Employee user)
    {
        this.userrepo.save(user);


    }
}
