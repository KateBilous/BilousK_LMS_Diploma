package com.bilous.BK_LMS_diploma.presentation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.*;

import static com.bilous.BK_LMS_diploma.presentation.Command.*;

public abstract class CommandDispatcher {

    private static final Logger log = LogManager.getLogger(CommandDispatcher.class);

    private final List<Command> viewCommands;
   // protected final SessionServiceImpl sessionService;

    public CommandDispatcher(List<Command> viewCommands) {
        List<Command> commands = new ArrayList<>(Arrays.asList(TERMINATE, LOGOUT, HELP));
        commands.addAll(viewCommands);
        this.viewCommands = Collections.unmodifiableList(commands);
    }



    public Optional<Command> parseCommandStringInput(String commandString) {
        return Optional.ofNullable(Command.getCommand(commandString.toLowerCase()));
                //Command.getCommand(commandString.toLowerCase());
    }

    public abstract void executeCommand(Command command);

    public void executeRootCommand(Command command) {
        switch (command) {
            case HELP:
                executeHelp();
                break;
            case LOGOUT:
                executeLogout();
            case TERMINATE:
                executeTerminate();
                break;
            default:
                log.error("Could not execute command "+ command);
        }
    }


    private void executeStats() {
    }

    private void executeRegister() {
    }

    private void executeProfile() {
    }

    private void executeLogin() {
    }

    private void executeHomeWorks() {
    }

    public void executeLogout() {
        //sessionService.closeCurrentSession();
        log.info("You have been logged out");
    }

    public void executeHelp() {
        StringBuilder strb = new StringBuilder("The following command available are this");
        for (Command command: viewCommands){
            strb.append(System.lineSeparator())
                    .append(command);
        }

    }

    protected void executeTerminate() {
        log.info("The app has been terminated");
        System.exit(1);
    }

}
