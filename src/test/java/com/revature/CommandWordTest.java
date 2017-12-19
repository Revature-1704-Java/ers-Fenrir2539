package com.revature;

import org.junit.Test;

import com.revature.Commands.CommandWords;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

public class CommandWordTest extends TestCase {
	
    @Test
    public void testCheckValidCommands() {
        CommandWords commandWords = new CommandWords();
        assertTrue(commandWords.isCommand("login"));
        assertTrue(commandWords.isCommand("new"));
        assertTrue(commandWords.isCommand("quit"));
        assertTrue(commandWords.isCommand("help"));
        assertTrue(commandWords.isCommand("viewEmp"));
        assertTrue(commandWords.isCommand("viewReim"));
    }

    public void testCheckInalidCommand() {
        CommandWords commandWords = new CommandWords();
        assertFalse(commandWords.isCommand("drop tables"));
    }
}
