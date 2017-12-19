package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO {
	public List<Employee> getAllEmployees() {
		PreparedStatement ps = null;
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE";
			ps = conn.prepareStatement(sql);
			//Add any variable to prepared stmts
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("EmployeeId");
				String userName =  rs.getString("UserName");
				String pass =  rs.getString("Pass");
				String firstName =  rs.getString("FirstName");
				String lastName =  rs.getString("LastName");
				String role =  rs.getString("EmployeeType");
				
				employee = new Employee(id, userName, pass, firstName, lastName, role);
				employees.add(employee);
			}
			rs.close();
			ps.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return employees;
	} //end getAllEmployees
	
	public Employee getEmployee(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EmployeeId =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("EmployeeId");
				String userName =  rs.getString("UserName");
				String pass =  rs.getString("Pass");
				String firstName =  rs.getString("FirstName");
				String lastName =  rs.getString("LastName");
				String role =  rs.getString("EmployeeType");
				
				employee = new Employee(id, userName, pass, firstName, lastName, role);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e) {
					e.getMessage();
				}
			}
			if (rs != null) {
					try {
						rs.close();
					}
					catch (SQLException e) {
						e.getMessage();
					}
			}
		}
		return employee;
	}//end getEmployee
	
	public Employee getEmployee(String uName, String uPass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE UserName =? AND Pass=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, uPass);
			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("EmployeeId");
				String userName =  rs.getString("UserName");
				String pass =  rs.getString("Pass");
				String firstName =  rs.getString("FirstName");
				String lastName =  rs.getString("LastName");
				String role =  rs.getString("EmployeeType");
				
				employee = new Employee(eid, userName, pass, firstName, lastName, role);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e) {
					e.getMessage();
				}
			}
			if (rs != null) {
					try {
						rs.close();
					}
					catch (SQLException e) {
						e.getMessage();
					}
			}
		}
		return employee;
	}//end getEmployee login
			
	public boolean insertEmployee(Employee e) {
		PreparedStatement ps = null;
		int rs;
		Employee employee = null;
		boolean insertWorked = false;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getPass());
			ps.setString(4, e.getFirstName());
			ps.setString(5, e.getLastName());
			ps.setString(6, e.getRole());
			rs = ps.executeUpdate();
			
			if (rs != 0) {
				System.out.println("Employee inserted");
	            conn.close();
	            insertWorked = true;
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException ex) {
					ex.getMessage();
				}
			}
		}
		return insertWorked;
	} //end insert
	
	//Update Employee?
	//Delete Employee?
	
}
