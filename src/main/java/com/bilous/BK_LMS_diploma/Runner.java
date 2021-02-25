package com.bilous.BK_LMS_diploma;

import com.bilous.BK_LMS_diploma.domain.*;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {

        Group group = new Group("Java", "Back-end", LocalDate.now());
        Student student = new Student("Kate", "Bilous", LocalDate.ofYearDay(1991, 5),
                group);
        Teacher teacher = new Teacher("Tom", "Harris", LocalDate.ofYearDay(1988, 9), "teacher");
        //Post post = new Post(group,);
        Feed feed = new Feed(group);
        Post post = new Post(feed, "kkkk", LocalDate.now());
        Lesson lesson = new Lesson(group, "smth", "kdkdkd");
        HomeTask homeTask = new HomeTask(lesson, 87, LocalDate.now(), "jsjsjsj", LocalDate.of(2021,
                9, 8));
        HomeWork homeWork = new HomeWork(homeTask, 85);

    }
}
