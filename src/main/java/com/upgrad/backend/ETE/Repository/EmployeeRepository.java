package com.upgrad.backend.ETE.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.backend.ETE.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{

}
