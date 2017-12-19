package com.revature;

import org.junit.Test;

import com.revature.util.ConnectionUtil;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtilTest {

	    @Test
	    public void testConnectionUtil() throws SQLException, IOException {   
	        Connection conn = ConnectionUtil.getConnection();
	    	assertTrue(conn != null);
	    }
	    
	    @Test(expected = SQLException.class)
	    public void testConnectionUtil2() throws SQLException, IOException {
	    	Connection conn = DriverManager.getConnection("databaseURL", "no", "works");
	    	assertTrue(conn == null);
	    }

}
