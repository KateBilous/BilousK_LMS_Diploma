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
        return new ArrayList<>(Storage.getPost().values());
    }

    @Override
    public Post savePost(Post post) {
        Post savedPost = buildPostFromTemplate(post);
        int newId = Storage.getNewPostId();
        savedPost.setId(newId);
        Storage.getPost().put(newId, savedPost);
        return savedPost;
    }

    private Post buildPostFromTemplate(Post post) {
        Post newPost = new Post(post.getFeeds(), post.getAuthor(), post.getDatePosted(), post.getText());
        newPost.setFeeds(post.getFeeds());
        newPost.setAuthor(post.getAuthor());
        newPost.setDatePosted(post.getDatePosted());
        newPost.setText(post.getText());
        return newPost;
    }

    @Override
    public Post getPostById(int id) {
        return Storage.getPost().get(id);

    }

    @Override
    public boolean updatePost(Post post) {
        int id = post.getId();
        Map<Integer, Post> posts = Storage.getPost();
        if (posts.containsKey(id)) {
            posts.put(id, post);
            return true;
        }
        return false;
    }


    @Override
    public boolean updatePostById(Post post) {
        int id = post.getId();
        Map<Integer, Post> posts = Storage.getPost();
        if (posts.containsKey(id)) {
            posts.put(id, post);
            return true;
        }
        return false;

    }

    @Override
    public boolean deletePostById(int id) {
        Map<Integer, Post> posts = Storage.getPost();
        if (posts.containsKey(id)) {
            posts.remove(id);
            return true;
        }
        return false;
    }
}
