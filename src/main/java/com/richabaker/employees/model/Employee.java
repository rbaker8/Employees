package com.richabaker.employees.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "Employee")
@Table(name="employee")
@Access(value=AccessType.FIELD)
public class Employee implements Serializable
{
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long Id;

    @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="supervisor_id")
    @JsonIgnore
    private Employee supervisor;
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private Set<EmployeeProperty> employeeProperties;

    @OneToMany(mappedBy="supervisor")
    private Set<Employee> subordinates = new HashSet<Employee>();

    @Column(name="supervisor_id", insertable=false, updatable=false)
    private Long supervisorId;

    @Transient
    private List<Employee> directReportsArray;
    @Transient
    private Map<String, String> properties;

    public Employee()
    {
        Id = 0L;
        supervisorId = 0L;
        properties = new HashMap<>();
        directReportsArray = new ArrayList<>();
    }

    public void setId(long Id)
    {
        this.Id = Id;
    }

    public long getId()
    {
        return this.Id;
    }

    public void setSupervisorId(Long Id)
    {
        this.supervisorId = Id;
    }

    public Long getSupervisorId()
    {
        return this.supervisorId;
    }

    public void SetDirectReportsArray(List<Employee> reports) {  this.directReportsArray = reports; }

    public List<Employee> getDirectReportsArray()  { return this.directReportsArray; }

    public void setProperties(Map<String, String> properties)
    {
        this.properties = properties;
    }

    public Map<String, String> getProperties()
    {
        return this.properties;
    }

    public void setSubordinates(Set<Employee> subordinates)
    {
        this.subordinates = subordinates;
    }

    public Set<Employee> getSubordinates()
    {
        return this.subordinates;
    }

    public void setEmployeeProperties(Set<EmployeeProperty> properties)
    {
        this.employeeProperties = properties;
    }

    public Set<EmployeeProperty> getEmployeeProperties()
    {
        return this.employeeProperties;
    }

    public void setSupervisor(Employee employee)
    {
        this.supervisor = employee;
    }
    public Employee getSupervisor()
    {
        return this.supervisor;
    }
}