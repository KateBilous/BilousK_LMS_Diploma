package com.bilous.BK_LMS_diploma.service;

import com.bilous.BK_LMS_diploma.domain.Feed;
import com.bilous.BK_LMS_diploma.domain.Post;

import java.time.LocalDate;

public interface PostService {

    Post createPost(Feed feeds, String text, LocalDate datePosted, String author);

    Post savePost(Post post);
}
