package com.richabaker.employees.web;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.richabaker.employees.model.Employee;
import com.richabaker.employees.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    public EmployeeController() {}
    private EmployeeService employeeService;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getTopLevelEmployees()
    {
        List<Employee> employees = employeeService.getTopLevelEmployees();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String str = "";
        try
        {
            str = mapper.writeValueAsString(employees);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getEmployee(@PathVariable("id") long id)
    {
        Employee employee = employeeService.getEmployee(id, true);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String str = "";
        try
        {
            str = mapper.writeValueAsString(employee);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }
}