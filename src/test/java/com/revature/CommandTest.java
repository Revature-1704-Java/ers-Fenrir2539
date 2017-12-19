package com.revature;

import org.junit.Test;

import com.revature.Commands.Command;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

public class CommandTest extends TestCase {
	 
    @Test
    public void testCommandConstructor() {
        Command command = new Command("test");
        assertEquals(command.getString(), "test");
    }
    
    @Test
    public void testCommandConstructorFail() {
        Command command = new Command("test");
        assertFalse(command.getString().equals("ipsum"));
    }
}
