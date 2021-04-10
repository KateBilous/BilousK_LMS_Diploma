package com.bilous.BK_LMS_diploma.dao.model;

import com.bilous.BK_LMS_diploma.dao.Post;

import java.util.List;

public interface PostDao {

    List<Post> getAll();

    Post savePost(Post post);

    Post getPostById(int id);

    boolean updatePostById(Post post, int id);

    boolean deletePostById(int id);


}
