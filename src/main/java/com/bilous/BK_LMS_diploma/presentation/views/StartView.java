package com.bilous.BK_LMS_diploma.presentation.views;


import com.bilous.BK_LMS_diploma.presentation.Command;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AbstractView {

    private static final Logger log = LogManager.getLogger(AbstractView.class);

    private final CommandDispatcher dispatcher;

    public AbstractView(CommandDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true)
            String commandString = scanner.next();
            Command command= parseCommandStringInput(commandString);
            if (command == null) {
                log.warn("Cannot parse command: {}. Enter valid command. {}{}",
                        commandString, System.lineSeparator(), Command.help());
                continue;
            }
            dispatcher.executeCommand(command);

        }
    }


}
