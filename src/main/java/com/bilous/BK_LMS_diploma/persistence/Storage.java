package com.bilous.BK_LMS_diploma.persistence;

import com.bilous.BK_LMS_diploma.domain.*;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static Map<Integer, Group> groupsMap = new HashMap<>();

    private static Map<Integer, User> usersMap = new HashMap<>();

    private static Map<Integer, Teacher> teachersMap = new HashMap<>();

    private static Map<Integer, Student> studentsMap = new HashMap<>();

    private static Map<Integer, HomeTask> homeTasksMap = new HashMap<>();

    private static Map<Integer, Post> postsMap = new HashMap<>();

    private static Map<Integer, Lesson> lessonsMap = new HashMap<>();

    private static Map<Integer, Feed> feedsMap = new HashMap<>();

    private static Map<Integer, HomeWork> homeWorksMap = new HashMap<>();

    public static Map<Integer, Group> getGroups() {
        return groupsMap;
    }

    public static Map<Integer, User> getUsers() {
        return usersMap;
    }

    public static Map<Integer, Teacher> getTeachers() {
        return teachersMap;
    }

    public static Map<Integer, Student> getStudents() {
        return studentsMap;
    }

    public static Map<Integer, Post> getPosts() {
        return postsMap;
    }

    public static Map<Integer, Lesson> getLessons() {
        return lessonsMap;
    }

    public static Map<Integer, Feed> getFeeds() {
        return feedsMap;
    }

    public static Map<Integer, HomeTask> getHomeTasks() {
        return homeTasksMap;
    }

    public static Map<Integer, HomeWork> getHomeWorks() {
        return homeWorksMap;
    }


    public static int getNewGroupId() {
        int max = 0;
        for (Integer currentID : groupsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewUserId() {
        int max = 0;
        for (Integer currentID : usersMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewTeacherId() {
        int max = 0;
        for (Integer currentID : teachersMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewStudentId() {
        int max = 0;
        for (Integer currentID : studentsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewPostId() {
        int max = 0;
        for (Integer currentID : postsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewLessonId() {
        int max = 0;
        for (Integer currentID : lessonsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewFeedId() {
        int max = 0;
        for (Integer currentID : feedsMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewHomeTaskId() {
        int max = 0;
        for (Integer currentID : homeTasksMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewHomeWorkId() {
        int max = 0;
        for (Integer currentID : homeWorksMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }


}
