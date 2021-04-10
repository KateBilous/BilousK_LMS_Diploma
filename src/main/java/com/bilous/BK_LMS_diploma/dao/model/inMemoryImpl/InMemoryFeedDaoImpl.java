package com.bilous.BK_LMS_diploma.dao.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.dao.Feed;
import com.bilous.BK_LMS_diploma.dao.model.FeedDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryFeedDaoImpl implements FeedDao {


    @Override
    public List<Feed> getAll() {
        return new ArrayList<>(Persistence.getInstance().getFeeds().values());
    }

    @Override
    public Feed saveFeed(Feed feed) {
        int newId = Persistence.getInstance().getNewFeedId();
        feed.setId(newId);
        return Persistence.getInstance().getFeeds().put(feed.getId(), feed);

    }

    @Override
    public Feed getFeedById(int id) {
        return Persistence.getInstance().getFeeds().get(id);

    }

    @Override
    public boolean updateFeedById(Feed feed, int id) {
        Map<Integer, Feed> feeds = Persistence.getInstance().getFeeds();
        if (feeds.containsKey(feed.getId())) {
            feeds.put(feed.getId(), feed);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteFeedById ( int id){
        Map<Integer, Feed> feeds = Persistence.getInstance().getFeeds();
        if (feeds.containsKey(id)) {
            feeds.remove(id);
            return true;
        }
        return false;
    }
}
