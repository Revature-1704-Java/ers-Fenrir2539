package com.revature.Commands;

import java.util.Set;
import java.util.HashSet;


public class CommandWords {

    private Set<String> validCommands = new HashSet<String>();

    public CommandWords() {
        validCommands.add("login");
        validCommands.add("viewEmp");
        validCommands.add("new");
        validCommands.add("quit");
        validCommands.add("viewReim");
        validCommands.add("help");
    }   

    public boolean isCommand(String str) {
        if (validCommands.contains(str)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void showAll() {
        for(String command: validCommands) {
            System.out.print(command + ",  ");
        }
        System.out.println();
    }
}