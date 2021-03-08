package com.bilous.BK_LMS_diploma.domain.model;

import com.bilous.BK_LMS_diploma.domain.Feed;


import java.util.List;

public interface FeedDao {


    List<Feed> getAll();

    Feed getFeedById(int id);

    Feed saveFeed(Feed feed);

    boolean updateFeedById(Feed feed, int id);

    boolean deleteFeedById(int id);
}
