package com.bilous.BK_LMS_diploma.presentation.views;

import com.bilous.BK_LMS_diploma.presentation.Command;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import com.bilous.BK_LMS_diploma.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bilous.BK_LMS_diploma.presentation.Command.PROFILE;
import static com.bilous.BK_LMS_diploma.presentation.Command.STATS;

public class UserViewDispatcher extends GlobalDispatcher {


    private static final Logger log = LogManager.getLogger(UserViewDispatcher.class);


    public UserViewDispatcher() {
        super(Arrays.asList(PROFILE, STATS));
    }

    @Override
    public void executeCommand(Command command){
        switch (command){
            case PROFILE:
                executeHelp();
                break;
            case STATS:
                executeTerminate();
                break;
            default:
                executeGlobalCommand(command);
        }

    }
}
