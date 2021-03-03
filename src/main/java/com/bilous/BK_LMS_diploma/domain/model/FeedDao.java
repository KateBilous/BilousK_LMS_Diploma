package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.Feed;


import java.util.List;

public interface FeedDao {


    List<Feed> getAll();

    Feed saveFeed(Feed feed);

    Feed getFeedById(int id);

    boolean updateFeed(Feed feed);

    boolean updateFeedById(Feed feed);

    boolean deleteFeedById(int id);
}
