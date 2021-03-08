package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Feed;
import com.bilous.BK_LMS_diploma.domain.model.FeedDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryFeedDaoImpl implements FeedDao {


    @Override
    public List<Feed> getAll() {
        return new ArrayList<>(Persistence.getInstance().getFeed().values());
    }

    @Override
    public Feed saveFeed(Feed feed) {
        Feed savedFeed = buildFeedFromTemplate(feed);
        int newId = Persistence.getInstance().getNewFeedId();
        savedFeed.setId(newId);
        Persistence.getInstance().getFeed().put(newId, savedFeed);
        return savedFeed;
    }

    private Feed buildFeedFromTemplate(Feed feed) {
        Feed newFeed = new Feed(feed.getGroup());

        return newFeed;
    }

    @Override
    public Feed getFeedById(int id) {
        return Persistence.getInstance().getFeed().get(id);

    }

    @Override
    public boolean updateFeed(Feed feed) {
        int id = feed.getId();
        Map<Integer, Feed> feeds = Persistence.getInstance().getFeed();
        if (feeds.containsKey(id)) {
            feeds.put(id, feed);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateFeedById(Feed feed) {
        int id = feed.getId();
        Map<Integer, Feed> feeds = Persistence.getInstance().getFeed();
        if (feeds.containsKey(id)) {
            feeds.put(id, feed);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteFeedById(int id) {
        Map<Integer, Feed> feeds = Persistence.getInstance().getFeed();
        if (feeds.containsKey(id)) {
            feeds.remove(id);
            return true;
        }
        return false;
    }
}
