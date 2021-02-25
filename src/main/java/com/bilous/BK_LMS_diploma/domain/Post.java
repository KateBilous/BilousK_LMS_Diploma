package com.bilous.BK_LMS_diploma.domain;

import java.time.LocalDate;
import java.util.Set;

public class Post  {

    private Feed feeds;
    private String  text;
    private LocalDate datePosted;

    public Post(Feed feeds, String text, LocalDate datePosted) {
        this.feeds = feeds;
        this.text = text;
        this.datePosted = datePosted;
    }

    public Feed getFeeds() {
        return feeds;
    }

    @Override
    public String toString() {
        return "Post{" +
                "feeds=" + feeds +
                ", text='" + text + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }
}




