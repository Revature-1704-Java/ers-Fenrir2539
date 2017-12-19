package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAO {
	
	//get All reimbursements for employee
	public List<Reimbursement> getAllReimbursements(int id) {
		PreparedStatement ps = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		Reimbursement reimbursement = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE AuthorId = id";
			ps = conn.prepareStatement(sql);
			//Add any variable to prepared stmts
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int rid = rs.getInt("ReimbusmentId");
				Double amount =  rs.getDouble("Amount");
				Date dateSubmitted =  rs.getDate("DateSubmitted");
				Date dateResolved =  rs.getDate("DateResolved");
				String desc =  rs.getString("Description");
				int authorId =  rs.getInt("AuthorId");
				int resolverId =  rs.getInt("ResolverId");
				String status = rs.getString("Status");
				
				
				reimbursement = new Reimbursement(rid, amount, dateSubmitted, dateResolved, desc, authorId, resolverId, status);
				reimbursements.add(reimbursement);
			}
			rs.close();
			ps.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return reimbursements;
	} //end getAllEmployees
	
	//get all reimbursements for manager
	public List<Reimbursement> getAllReimbursementsManager(int id) {
		PreparedStatement ps = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		Reimbursement reimbursement = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT";
			ps = conn.prepareStatement(sql);
			//Add any variable to prepared stmts
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int rid = rs.getInt("ReimbusmentId");
				Double amount =  rs.getDouble("Amount");
				Date dateSubmitted =  rs.getDate("DateSubmitted");
				Date dateResolved =  rs.getDate("DateResolved");
				String desc =  rs.getString("Description");
				int authorId =  rs.getInt("AuthorId");
				int resolverId =  rs.getInt("ResolverId");
				String status = rs.getString("Status");
				
				
				reimbursement = new Reimbursement(rid, amount, dateSubmitted, dateResolved, desc, authorId, resolverId, status);
				reimbursements.add(reimbursement);
			}
			rs.close();
			ps.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return reimbursements;
	}
	
	//create reimbursement
	public boolean insertReimbursement(Reimbursement r) {
		PreparedStatement ps = null;
		int rs;
		Reimbursement reimbursement = null;
		boolean insertWorked = false;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setDouble(2, r.getAmount());
			ps.setDate(3, r.getDate_submitted());
			ps.setDate(4, r.getDate_resolved());
			ps.setString(5, r.getDescription());
			ps.setInt(6, r.getAuthor_id());
			ps.setInt(7, r.getResolver_id());
			ps.setString(8, r.getStatus());
			rs = ps.executeUpdate();
			
			if (rs != 0) {
				System.out.println("Reimbursement submitted");
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
	}

}
