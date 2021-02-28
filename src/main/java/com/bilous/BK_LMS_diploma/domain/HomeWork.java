package com.bilous.BK_LMS_diploma.domain;

import java.util.Objects;

public class HomeWork {

    private HomeTask homeTasks;
    private int score;
    private String resolution;
    private String author;

    public HomeWork(HomeTask homeTasks, int score, String resolution, String author) {
        this.homeTasks = homeTasks;
        this.score = score;
        this.resolution = resolution;
        this.author = author;
    }

    public HomeTask getHomeTasks() {
        return homeTasks;
    }

    public void setHomeTasks(HomeTask homeTasks) {
        this.homeTasks = homeTasks;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "homeTasks=" + homeTasks +
                ", score=" + score +
                ", resolution='" + resolution + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWork homeWork = (HomeWork) o;
        return score == homeWork.score &&
                homeTasks.equals(homeWork.homeTasks) &&
                resolution.equals(homeWork.resolution) &&
                author.equals(homeWork.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTasks, score, resolution, author);
    }
}
