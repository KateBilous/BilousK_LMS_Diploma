package com.bilous.BK_LMS_diploma.persistence;

import com.bilous.BK_LMS_diploma.domain.*;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static Map<Integer, Group> groupMap = new HashMap<>();

    private static Map<Integer, User> userMap = new HashMap<>();

    private static Map<Integer, Teacher> teacherMap = new HashMap<>();

    private static Map<Integer, Student> studentMap = new HashMap<>();

    private static Map<Integer, HomeTask> homeTaskMap = new HashMap<>();

    private static Map<Integer, Post> postMap = new HashMap<>();

    private static Map<Integer, Lesson> lessonMap = new HashMap<>();

    private static Map<Integer, Feed> feedMap = new HashMap<>();

    private static Map<Integer, HomeWork> homeWorkMap = new HashMap<>();

    public static Map<Integer, Group> getGroups() {
        return groupMap;
    }

    public static Map<Integer, User> getUser() {
        return userMap;
    }

    public static Map<Integer, Teacher> getTeacher() {
        return teacherMap;
    }

    public static Map<Integer, Student> getStudent() {
        return studentMap;
    }

    public static Map<Integer, Post> getPost() {
        return postMap;
    }

    public static Map<Integer, Lesson> getLesson() {
        return lessonMap;
    }

    public static Map<Integer, Feed> getFeed() {
        return feedMap;
    }

    public static Map<Integer, HomeTask> getHomeTask() {
        return homeTaskMap;
    }

    public static Map<Integer, HomeWork> getHomeWork() {
        return homeWorkMap;
    }


    public static int getNewGroupId() {
        int max = 0;
        for (Integer currentID : groupMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewUserId() {
        int max = 0;
        for (Integer currentID : userMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewTeacherId() {
        int max = 0;
        for (Integer currentID : teacherMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewStudentId() {
        int max = 0;
        for (Integer currentID : studentMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewPostId() {
        int max = 0;
        for (Integer currentID : postMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewLessonId() {
        int max = 0;
        for (Integer currentID : lessonMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewFeedId() {
        int max = 0;
        for (Integer currentID : feedMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewHomeTaskId() {
        int max = 0;
        for (Integer currentID : homeTaskMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }

    public static int getNewHomeWorkId() {
        int max = 0;
        for (Integer currentID : homeWorkMap.keySet()) {
            if (currentID > max) {
                max = currentID;
            }
        }
        return ++max;
    }


}
