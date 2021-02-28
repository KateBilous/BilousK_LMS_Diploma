package com.bilous.BK_LMS_diploma.domain;

import java.util.ArrayList;
import java.util.List;

public class Feed {

    private final Group group;
    private List<Post> posts;


    public Feed(Group group) {
        this.group = group;
        posts = new ArrayList<>();
    }

    public Group getGroup() {
        return group;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
