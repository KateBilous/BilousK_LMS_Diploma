package com.bilous.BK_LMS_diploma.domain;

import java.util.Set;

public class Feed  {

    private final Group group;
    private Set<Post> posts;


    public Feed(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public  Set<Post> getPosts() {
        return posts;
    }

    public void addPost (Post post){posts.add(post);}
}
