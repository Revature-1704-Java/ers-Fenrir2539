package com.revature;

import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import java.util.List;

/**
 *
 */
public class EmployeeDAOTest extends TestCase {

    @Test
    public void testEmployeeDAOgetAll() {   
        EmployeeDAO d = new EmployeeDAO();
        List<Employee> employees = null;
        employees = d.getAllEmployees();
    	assertTrue(employees != null);
    }
    
    @Test
    public void testEmployeeDAOgetOne() {   
        EmployeeDAO d = new EmployeeDAO();
        Employee e = null;
        e = d.getEmployee(1);
    	assertTrue(e != null);
    }
    
    @Test
    public void testEmployeeDAOgetOneFail() {   
        EmployeeDAO d = new EmployeeDAO();
        Employee e = null;
        e = d.getEmployee(999);
    	assertTrue(e == null);
    }
    
    @Test
    public void testEmployeeDAOgetOnePassword() {   
        EmployeeDAO d = new EmployeeDAO();
        Employee e = null;
        e = d.getEmployee("aSwan", "aSon");
    	assertTrue(e != null);
    }
    
    @Test
    public void testEmployeeDAOgetOnePasswordFail() {   
        EmployeeDAO d = new EmployeeDAO();
        Employee e = null;
        e = d.getEmployee("notA", "password");
    	assertTrue(e == null);
    }

}
