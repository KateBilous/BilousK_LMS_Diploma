package com.bilous.BK_LMS_diploma.presentation.views;


import com.bilous.BK_LMS_diploma.presentation.Command;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import com.bilous.BK_LMS_diploma.service.UserService;
import jdk.nashorn.internal.runtime.options.Option;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Scanner;

public class StartView extends AbstractView {

    private static final Logger log = LogManager.getLogger(StartView.class);

    public StartView(UserService userService){
        super( new StartViewDispatcher (userService));
    }


    //public StartView(CommandDispatcher dispatcher) {
      //  super(dispatcher);
    //}
    //private final CommandDispatcher dispatcher;
    //public StartView(CommandDispatcher dispatcher) {
      // super();

      // this.dispatcher = dispatcher;
   // }

    //public void run() {
       // Scanner scanner = new Scanner(System.in);
        //while (true) {
           // String commandString = scanner.next();
           // Optional <Command> command = Optional.ofNullable(dispatcher.parseCommandStringInput(commandString));
            //if (!command.isPresent()) {
               // log.warn("Cannot parse command: {}. Enter valid command.{}" +
                       // commandString, dispatcher.executeRootCommand(Command.HELP));
               // continue;
           // }
          //  dispatcher.executeCommand(command);

      //  }
  // }


}



