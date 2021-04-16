package com.bilous.BK_LMS_diploma.dao;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private Integer id;
    private Feed feeds;
    private String text;
    private LocalDate datePosted;
    private String author;

    public Post(Feed feeds, String text, LocalDate datePosted, String author) {
        this.feeds = feeds;
        this.text = text;
        this.datePosted = datePosted;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Feed getFeeds() {
        return feeds;
    }

    public void setFeeds(Feed feeds) {
        this.feeds = feeds;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "feeds=" + feeds +
                ", text='" + text + '\'' +
                ", datePosted=" + datePosted +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return feeds.equals(post.feeds) &&
                text.equals(post.text) &&
                datePosted.equals(post.datePosted) &&
                author.equals(post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feeds, text, datePosted, author);
    }
}




