package com.bilous.BK_LMS_diploma.dao.jdbc.Jdbcimpl;

import com.bilous.BK_LMS_diploma.dao.Post;
import com.bilous.BK_LMS_diploma.dao.model.PostDao;
import com.bilous.BK_LMS_diploma.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcPostDaoImpl implements PostDao {
    //TODO connection JDBC instead Persistence

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(Persistence.getInstance().getPosts().values());
    }

    @Override
    public Post savePost(Post post) {
        int newId = Persistence.getInstance().getNewPostId();
        post.setId(newId);
        return Persistence.getInstance().getPosts().put(post.getId(), post);
    }


    @Override
    public Post getPostById(int id) {
        return Persistence.getInstance().getPosts().get(id);

    }

    @Override
    public boolean updatePostById(Post post, int id) {
        Map<Integer, Post> posts = Persistence.getInstance().getPosts();
        if (posts.containsKey(post.getId())) {
            posts.put(post.getId(), post);
            return true;
        }
        return false;
    }




    @Override
    public boolean deletePostById(int id) {
        Map<Integer, Post> posts = Persistence.getInstance().getPosts();
        if (posts.containsKey(id)) {
            posts.remove(id);
            return true;
        }
        return false;
    }
}
