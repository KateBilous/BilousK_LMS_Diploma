package com.bilous.BK_LMS_diploma.dao;

import java.time.LocalDate;
import java.util.Objects;

public class HomeTask {


    private Integer id;
    private Lesson lesson;
    private int retake;
    private LocalDate date;
    private String materials;
    private LocalDate deadline;


    public HomeTask(Lesson lesson, int task, LocalDate date, String materials, LocalDate deadline) {
        this.lesson = lesson;
        this.retake = task;
        this.date = date;
        this.materials = materials;
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getRetake() {
        return retake;
    }

    public void setRetake(int retake) {
        this.retake = retake;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "HomeTask{" +
                "homeWork=" + lesson +
                ", task=" + retake +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", dedLine=" + deadline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeTask homeTask = (HomeTask) o;
        return retake == homeTask.retake &&
                lesson.equals(homeTask.lesson) &&
                date.equals(homeTask.date) &&
                materials.equals(homeTask.materials) &&
                deadline.equals(homeTask.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lesson, retake, date, materials, deadline);
    }
}
