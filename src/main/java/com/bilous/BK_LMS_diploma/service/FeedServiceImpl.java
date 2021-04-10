package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.Feed;
import com.bilous.BK_LMS_diploma.dao.Group;
import com.bilous.BK_LMS_diploma.dao.model.FeedDao;

public class FeedServiceImpl implements FeedService {

    private final FeedDao feedDao;


    public FeedServiceImpl(FeedDao feedDao) {
        this.feedDao = feedDao;
    }

    @Override
    public Feed creteFeed(Group group) {
        return new Feed(group);
    }
}
