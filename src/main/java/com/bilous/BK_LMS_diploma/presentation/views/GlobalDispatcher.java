package com.bilous.BK_LMS_diploma.presentation.views;

import com.bilous.BK_LMS_diploma.presentation.Command;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalDispatcher extends CommandDispatcher {

    private static final Logger log = LogManager.getLogger(UserViewDispatcher.class);

    public GlobalDispatcher(List<Command> viewCommands){
        super (initGlobalCommand(viewCommands));
    }



    private static List<Command> initGlobalCommand(List<Command> viewCommands){
        List<Command> commands = new ArrayList<>(Arrays.asList(Command.ACCOUNT, Command.GROUP, Command.HOMEWORKS,
                Command.LESSONS));
        commands.addAll(viewCommands);
        return commands;
    }

    @Override
    public void executeCommand(Command command){executeGlobalCommand(command);}

    public void executeGlobalCommand(Command command){
        switch (command){
            case ACCOUNT:
                executeLogout();
            case GROUP:
                executeHelp();
                break;
            case HOMEWORKS:
                executeTerminate();
            case LESSONS:
                executeTerminate();
            default:
               executeRootCommand(command);
        }
    }
}
