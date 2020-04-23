package com.pcc.candidatechallenge.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class EmployeePropertyKey implements Serializable
{
    @Column(name = "employee_id")
    private long employeeId;
    @Column(name = "key")
    private String key;

    public EmployeePropertyKey() { }
    public EmployeePropertyKey(long employeeId, String key)
    {
        this.employeeId = employeeId;
        this.key = key;
    }

    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePropertyKey that = (EmployeePropertyKey) o;
        if (employeeId != that.employeeId) return false;
        return key.equals(that.key);
    }

    @Override
    public int hashCode()
    {
        int result = new Long(employeeId).hashCode();
        result = 31 * result + key.hashCode();
        return result;
    }
}
