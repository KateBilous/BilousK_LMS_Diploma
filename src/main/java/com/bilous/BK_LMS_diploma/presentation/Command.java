package com.bilous.BK_LMS_diploma.presentation;

import java.util.*;

public enum  Command {

    //Default command
    TERMINATE("terminate", "Save current state and save the app"),
    LOGOUT("logout", "logout from the LMS"),
    HELP("help", "Shows all commands"),

    //StartView commands
    REGISTER("register", "Register to the system "),
    LOGIN("login", "Login to the LMS"),

    //Global commands
    HOMEWORKS("homeworks", "Show students list and compleated homeworks"),
    ACCOUNT("account", "Go to user account view "),
    GROUP("group", "Goto group view"),
    LESSONS("lessons", "Go to lesson view"),

    //UserView commands
    PROFILE("shows", "Shows basic user information"),
    STATS("stats", "Show teacher's statistics");


    private final String value;
    private final String description;

    Command(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Set<String> getValues() {
        Set<String> set = new HashSet<>(Arrays.asList(
                TERMINATE.value,
                HELP.value));
        return Collections.unmodifiableSet(set);
    }

    public static Command getCommand(String commandString) {
        switch (commandString) {
            case "help":
                return HELP;
            case "terminate":
                return TERMINATE;
            case "homeworks":
                return HOMEWORKS;
            case "login":
                return LOGIN;
            case "logout":
                return LOGOUT;
            case "profile":
                return PROFILE;
            case "register":
                return REGISTER;
            case "stats":
                return STATS;
            case "account":
                return ACCOUNT;
            case "group":
                return GROUP;
            case "lessons":
                return LESSONS;

            default:
                return null;
        }

    }

    public static void help() {
        StringBuilder sb = new StringBuilder("Valid commands: ");
        for (Command command : Command.values()) {
            sb.append(System.lineSeparator())
                    .append(command.value).append(" - ")
                    .append(command.description);
        }
        System.out.println(sb);

    }


}
