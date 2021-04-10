package com.bilous.BK_LMS_diploma.persistence;

import com.bilous.BK_LMS_diploma.dao.*;

import java.util.HashMap;
import java.util.Map;

public class Persistence {

    private final Map<Integer, Group> groupsMap;
    private final Map<Integer,User> usersMap;
    private final Map<Integer, Teacher> teachersMap;
    private final Map<Integer, Student> studentsMap;
    private final Map<Integer, HomeTask> homeTasksMap;
    private final  Map<Integer, Post> postsMap;
    private final Map<Integer, Lesson> lessonsMap;
    private final Map<Integer, Feed> feedsMap;
    private final Map<Integer, HomeWork> homeWorksMap;

    private Persistence(){
        this.groupsMap = new HashMap<Integer, Group>() {};
        this.usersMap = new HashMap<Integer, User>(){};
        this.teachersMap = new HashMap<Integer, Teacher>(){};
        this.studentsMap = new HashMap<Integer, Student>(){};
        this.homeTasksMap = new HashMap<Integer, HomeTask>(){};
        this.postsMap = new HashMap<Integer, Post>(){};
        this.lessonsMap = new HashMap<Integer, Lesson>(){};
        this.feedsMap = new HashMap<Integer, Feed>(){};
        this.homeWorksMap = new HashMap<Integer, HomeWork>(){};

    }

    public static Persistence getInstance(){
        return PersistenceHolder.instance;
    }

    public static class PersistenceHolder{
        private static final Persistence instance = new Persistence();

    }


    public  Map < Integer,Group> getGroups() {
        return groupsMap;
    }

    public  Map<Integer, User> getUsers() {
        return usersMap;
    }

    public  Map<Integer, Teacher> getTeachers() {
        return teachersMap;
    }

    public  Map<Integer, Student> getStudents() {
        return studentsMap;
    }

    public  Map<Integer, Post> getPosts() {
        return postsMap;
    }

    public  Map<Integer, Lesson> getLessons() {
        return lessonsMap;
    }

    public  Map<Integer, Feed> getFeeds() {
        return feedsMap;
    }

    public  Map<Integer, HomeTask> getHomeTasks() {
        return homeTasksMap;
    }

    public  Map<Integer, HomeWork> getHomeWorks() {
        return homeWorksMap;
    }


    public int getNewGroupId() {
        int max = 0;
        for (Integer currentID : groupsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewUserId() {
        int max = 0;
        for (Integer currentID : usersMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewTeacherId() {
        int max = 0;
        for (Integer currentID : teachersMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewStudentId() {
        int max = 0;
        for (Integer currentID : studentsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewPostId() {
        int max = 0;
        for (Integer currentID : postsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewLessonId() {
        int max = 0;
        for (Integer currentID : lessonsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public int getNewFeedId() {
        int max = 0;
        for (Integer currentID : feedsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewHomeTaskId() {
        int max = 0;
        for (Integer currentID : homeTasksMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public  int getNewHomeWorkId() {
        int max = 0;
        for (Integer currentID : homeWorksMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }


}
