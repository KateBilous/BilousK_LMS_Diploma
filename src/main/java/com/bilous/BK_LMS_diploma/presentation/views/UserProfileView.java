package com.bilous.BK_LMS_diploma.presentation.views;

import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserProfileView  extends AbstractView{

    private static final Logger log = LogManager.getLogger(StartView.class);


    public UserProfileView(CommandDispatcher dispatcher) {
        super(dispatcher);
    }
}
