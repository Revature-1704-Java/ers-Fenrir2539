package com.revature;

import org.junit.Test;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import java.util.List;

public class ReimbursementDAOTest extends TestCase{
	 
	@Test
	 public void testGetAllReims() {   
		 List<Reimbursement> r = null;
		 ReimbursementDAO d = new ReimbursementDAO();
		 r = d.getAllReimbursements(1);
		 assertTrue(r != null);
		 
	 }
	
	@Test
	 public void testGetAllReimsMgr() {   
		 List<Reimbursement> r = null;
		 ReimbursementDAO d = new ReimbursementDAO();
		 r = d.getAllReimbursementsManager();
		 assertTrue(r != null);
		 
	 }
}
