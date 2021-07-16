package com.richabaker.employees.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="property")
@Access(value=AccessType.FIELD)
public class EmployeeProperty implements Serializable
{
    public EmployeeProperty() {}
    public void setId(EmployeePropertyKey Id)
    {
        this.Id = Id;
    }
    public EmployeePropertyKey getId()
    {
        return this.Id;
    }
    public void setEmployee(Employee employee)
    {
        this.employee=employee;
    }
    public Employee getEmployee()
    {
        return this.employee;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
    public String getValue()
    {
        return this.value;
    }

    @EmbeddedId
    private EmployeePropertyKey Id;
    @MapsId("employee_id")
    @JsonIgnore
    @ManyToOne Employee employee;

    @Column(name="value")
    private String value;
}
