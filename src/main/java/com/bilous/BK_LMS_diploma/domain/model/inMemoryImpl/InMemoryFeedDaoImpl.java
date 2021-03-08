package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Feed;
import com.bilous.BK_LMS_diploma.domain.model.FeedDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryFeedDaoImpl implements FeedDao {


    @Override
    public List<Feed> getAll() {
        return new ArrayList<>(Storage.getInstance().getFeeds().values());
    }

    @Override
    public Feed saveFeed(Feed feed) {
        int newId = Storage.getInstance().getNewFeedId();
        feed.setId(newId);
        return Storage.getInstance().getFeeds().put(feed.getId(), feed);

    private Feed buildFeedFromTemplate(Feed feed) {
        Feed newFeed = new Feed(feed.getGroup());

        return newFeed;
    }

    @Override
    public Feed getFeedById(int id) {
        return Storage.getInstance().getFeeds().get(id);

    }

    @Override
    public boolean updateFeedById(Feed feed, int id) {
        Map<Integer, Feed> feeds = Storage.getInstance().getFeeds();
        if (feeds.containsKey(feed.getId())) {
            feeds.put(feed.getId(), feed);
            return true;
        }
        return false;


    @Override
    public boolean updateFeedById(Feed feed) {
        int id = feed.getId();
        Map<Integer, Feed> feeds = Storage.getInstance().getFeeds();
        if (feeds.containsKey(id)) {
            feeds.put(id, feed);
            return true;
        }
        return false;



    @Override
    public boolean deleteFeedById(int id) {
        Map<Integer, Feed> feeds = Storage.getInstance().getFeeds();
        if (feeds.containsKey(id)) {
            feeds.remove(id);
            return true;
        }
        return false;
    }
}
