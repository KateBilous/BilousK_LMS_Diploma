package com.bilous.BK_LMS_diploma.presentation.views;

import com.bilous.BK_LMS_diploma.presentation.Command;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Scanner;

import static com.bilous.BK_LMS_diploma.presentation.Command.help;

public class AbstractView {


    private static final Logger log = LogManager.getLogger(StartView.class);

    private final CommandDispatcher dispatcher;


    public AbstractView(CommandDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void run () {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            help();
            String commandString = scanner.next();
            Optional<Command> command = dispatcher.parseCommandStringInput(commandString);
            if (!command.isPresent()) {
                log.warn("Could not parse command:"+ commandString);
                dispatcher.executeHelp();
            }
            dispatcher.executeCommand(command.get());



        }
    }


}
