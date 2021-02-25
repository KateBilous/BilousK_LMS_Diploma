package com.bilous.BK_LMS_diploma.domain;

import java.time.LocalDate;
import java.util.Objects;

public class HomeTask {


    private Lesson lesson;
    private int task;
    private LocalDate date;
    private String materials;
    private LocalDate dedLine;


    public HomeTask(Lesson lesson, int task, LocalDate date, String materials, LocalDate dedLine) {
        this.lesson = lesson;
        this.task = task;
        this.date = date;
        this.materials = materials;
        this.dedLine = dedLine;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
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

    public LocalDate getDedLine() {
        return dedLine;
    }

    public void setDedLine(LocalDate dedLine) {
        this.dedLine = dedLine;
    }

    @Override
    public String toString() {
        return "HomeTask{" +
                "homeWork=" + lesson +
                ", task=" + task +
                ", date=" + date +
                ", materials='" + materials + '\'' +
                ", dedLine=" + dedLine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeTask homeTask = (HomeTask) o;
        return task == homeTask.task &&
                lesson.equals(homeTask.lesson) &&
                date.equals(homeTask.date) &&
                materials.equals(homeTask.materials) &&
                dedLine.equals(homeTask.dedLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lesson, task, date, materials, dedLine);
    }
}
