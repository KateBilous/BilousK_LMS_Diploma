package com.bilous.BK_LMS_diploma.persistence;

import com.bilous.BK_LMS_diploma.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persistence {

    private final Map<Integer, Group> groupMap;
    private final Map<Integer,User> userMap;
    private final Map<Integer, Teacher> teacherMap;
    private final Map<Integer, Student> studentMap;
    private final Map<Integer, HomeTask> homeTaskMap;
    private final  Map<Integer, Post> postMap;
    private final Map<Integer, Lesson> lessonMap;
    private final Map<Integer, Feed> feedMap;
    private final Map<Integer, HomeWork> homeWorkMap;

    private Persistence(){
        this.groupMap = new HashMap<Integer, Group>() {};
        this.userMap = new HashMap<Integer, User>(){};
        this.teacherMap = new HashMap<Integer, Teacher>(){};
        this.studentMap = new HashMap<Integer, Student>(){};
        this.homeTaskMap = new HashMap<Integer, HomeTask>(){};
        this.postMap = new HashMap<Integer, Post>(){};
        this.lessonMap = new HashMap<Integer, Lesson>(){};
        this.feedMap = new HashMap<Integer, Feed>(){};
        this.homeWorkMap = new HashMap<Integer, HomeWork>(){};

    }

    public static Persistence getInstance(){
        return PersistenceHolder.instance;
    }

    public static class PersistenceHolder{
        private static final Persistence instance = new Persistence();

    }


    public  Map < Integer,Group> getGroup() {
        return groupMap;
    }

    public  Map<Integer, User> getUser() {
        return userMap;
    }

    public  Map<Integer, Teacher> getTeacher() {
        return teacherMap;
    }

    public  Map<Integer, Student> getStudent() {
        return studentMap;
    }

    public  Map<Integer, Post> getPost() {
        return postMap;
    }

    public  Map<Integer, Lesson> getLesson() {
        return lessonMap;
    }

    public  Map<Integer, Feed> getFeed() {
        return feedMap;
    }

    public  Map<Integer, HomeTask> getHomeTask() {
        return homeTaskMap;
    }

    public  Map<Integer, HomeWork> getHomeWork() {
        return homeWorkMap;
    }


    public int getNewGroupId() {
        int max = 0;
        for (Integer currentID : groupMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewUserId() {
        int max = 0;
        for (Integer currentID : userMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewTeacherId() {
        int max = 0;
        for (Integer currentID : teacherMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewStudentId() {
        int max = 0;
        for (Integer currentID : studentMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewPostId() {
        int max = 0;
        for (Integer currentID : postMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewLessonId() {
        int max = 0;
        for (Integer currentID : lessonMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public int getNewFeedId() {
        int max = 0;
        for (Integer currentID : feedMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewHomeTaskId() {
        int max = 0;
        for (Integer currentID : homeTaskMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewHomeWorkId() {
        int max = 0;
        for (Integer currentID : homeWorkMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }


}
