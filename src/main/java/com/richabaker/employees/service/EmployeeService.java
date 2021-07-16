package com.richabaker.employees.service;

import com.richabaker.employees.dao.EmployeeDao;
import com.richabaker.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("employeeService")
public class EmployeeService
{
    EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public List<Employee> getTopLevelEmployeesArray(boolean recursiveLoad)
    {
       return employeeDao.getTopLevelEmployees(recursiveLoad);
    }

    public List<Employee> getTopLevelEmployees()
    {
        return employeeDao.getTopLevelEmployees();
    }

    public Employee getEmployee(long ID, boolean recursiveLoad)
    {
        return employeeDao.getEmployee(ID, recursiveLoad);
    }
}
