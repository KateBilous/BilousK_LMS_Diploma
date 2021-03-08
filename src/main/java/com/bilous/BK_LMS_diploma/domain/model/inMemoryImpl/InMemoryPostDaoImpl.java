package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Post;
import com.bilous.BK_LMS_diploma.domain.model.PostDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryPostDaoImpl implements PostDao {

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(Storage.getInstance().getPosts().values());
    }

    @Override
    public Post savePost(Post post) {
        int newId = Storage.getInstance().getNewPostId();
        post.setId(newId);
        return Storage.getInstance().getPosts().put(post.getId(), post);
    }


    @Override
    public Post getPostById(int id) {
        return Storage.getInstance().getPosts().get(id);

    }

    @Override
    public boolean updatePostById(Post post, int id) {
        Map<Integer, Post> posts = Storage.getInstance().getPosts();
        if (posts.containsKey(post.getId())) {
            posts.put(post.getId(), post);
            return true;
        }
        return false;
    }




    @Override
    public boolean deletePostById(int id) {
        Map<Integer, Post> posts = Storage.getInstance().getPosts();
        if (posts.containsKey(id)) {
            posts.remove(id);
            return true;
        }
        return false;
    }
}
