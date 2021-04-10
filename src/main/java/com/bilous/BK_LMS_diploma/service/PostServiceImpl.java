package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.dao.Feed;
import com.bilous.BK_LMS_diploma.dao.Post;
import com.bilous.BK_LMS_diploma.dao.model.PostDao;

import java.time.LocalDate;

public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Post createPost(Feed feeds, String text, LocalDate datePosted, String author) {
        return new Post(feeds,text, datePosted, author);
    }

    @Override
    public Post savePost(Post post) {
        return postDao.savePost(post);
    }
}
