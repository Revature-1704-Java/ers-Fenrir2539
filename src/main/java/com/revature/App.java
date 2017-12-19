package com.revature;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.revature.Commands.Command;
import com.revature.Commands.CommandWords;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.parser.Parser;

public class App {
	
	private Parser parser;
	private boolean loggedIn = false;
	private CommandWords commandWords;
	private int currentId = 0;
	private Employee loggedInEmployee;
	private List<Employee> employeeList;
	private List<Reimbursement> reimbursementList;

	public static void main(String[] args) {
		//EmployeeDAO dao = new EmployeeDAO();
		//Employee e = new Employee(1, "aSwan", "aSon", "Alex", "Swanson", "employee");
		//dao.insertEmployee(e);
		//--
		//ReimbursementDAO rDao = new ReimbursementDAO();
		//Reimbursement r4 = new Reimbursement(7, 19.99, new Date(2017, 11, 11), null, "OCA Study Guide", 3, 2, "open");
		//rDao.insertReimbursement(r4);
		App application = new App();
		System.out.println("Please log in with login command");
		System.out.println("Try aSwan/aSon or meh/rab");
		application.run();
	}
	
	public App() {
		parser = new Parser();
	}
	
	public void run() {
		boolean finished = false;
		commandWords = new CommandWords();
		
		while(!finished) {
            Command command = parser.parseInput();
            finished = processCommand(command);
		}
	} //end run
	
	public boolean processCommand (Command command) {
        boolean wantToQuit = false; 
        if(!commandWords.isCommand(command.getString())) {
            System.out.println("Garbage In, Garbage Out process" + command.getString());
            return false;
        }

        if (command.getString().equals("help")) {
            printHelp();
        }
        else if (command.getString().equals("quit")) {
            return true;
        }
        else if (command.getString().equals("login")) {
            if(loggedIn) {
            	System.out.println("You are already logged in, "+loggedInEmployee.getFirstName());
            }
            else {
            	login();
            	
            }
        }
        else if (command.getString().equals("new")) {
            newReimbursement();
        }
        else if (command.getString().equals("viewReim")) {
            if(loggedInEmployee != null) {
            	viewReimbursements();
            }
            else {
            	System.out.println("login first");
            }
        }
        else if (command.getString().equals("viewEmp")) {
        	 if(loggedInEmployee != null) {
        		 viewEmployees();
             }
             else {
             	System.out.println("login first");
             }
       
        }
        // else command not recognized.
        return wantToQuit;
    } //end process
	
    public void printHelp() {
        commandWords.showAll();
    }
    
    public boolean login() {
    	loggedIn = false;
    	Scanner loginScanner = new Scanner(System.in);
    	 System.out.print("Enter your login: ");
         String userName= loginScanner.nextLine();
         System.out.print("Enter your password: ");
         String userPass= loginScanner.nextLine();
         
         EmployeeDAO d = new EmployeeDAO();
         loggedInEmployee = d.getEmployee(userName, userPass);
         if (loggedInEmployee != null ) {
        	 currentId = loggedInEmployee.getId();
        	 loggedIn = true;
        	 System.out.println("Welcome " +loggedInEmployee.getFirstName());
         }
         else {
        	 System.out.println("Login Failed");
         }
    	return loggedIn;
    }
    
    public boolean newReimbursement() {
    	System.out.println("Out of project scope, try again later");
    	return false;
    }
    
    public boolean viewReimbursements() {
    	boolean flag = false;
    	//If manager
    	if(loggedInEmployee.getRole().equals("manager")) {
    		ReimbursementDAO d = new ReimbursementDAO();
        	reimbursementList = d.getAllReimbursementsManager(loggedInEmployee.getId());
        	for (Reimbursement reim : reimbursementList) {
    			System.out.println(reim);
    		}
        	flag = true;
    	}
    	else {
    		//If employee
    		ReimbursementDAO d = new ReimbursementDAO();
    		reimbursementList = d.getAllReimbursements(loggedInEmployee.getId());
    		System.out.println("Id = "+loggedInEmployee.getId());
    		for (Reimbursement reim : reimbursementList) {
    			System.out.println(reim);
    		}
    		flag = true;
    	}
    	return flag;
    }
    
    public boolean viewEmployees() {
    	boolean flag = false;
    	//reject if not manager
    	if(loggedInEmployee.getRole().equals("manager")) {
    		EmployeeDAO d = new EmployeeDAO();
    		employeeList = d.getAllEmployees();
    		for (Employee emp : employeeList) {
    			System.out.println(emp);
    		}
    		flag = true;
    	}
    	else {
    		System.out.println("You cannot view this information unless you are a manager");
    	}
    	return flag;
    }

}
