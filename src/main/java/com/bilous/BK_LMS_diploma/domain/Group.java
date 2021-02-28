package com.bilous.BK_LMS_diploma.domain;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Group {

    private String name;
    private String direction;
    private LocalDate startDate;

    private List<Student> students;
    private List<Teacher> teachers;
    private LinkedList<Lesson> lessons;
    private final Feed feed;


    public Group(String name, String direction, LocalDate startDate) {
        this.name = name;
        this.direction = direction;
        this.startDate = startDate;
        this.feed = new Feed(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", startDate=" + startDate +
                ", students=" + students +
                ", teachers=" + teachers +
                ", lessons=" + lessons +
                ", feed=" + feed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) &&
                direction.equals(group.direction) &&
                startDate.equals(group.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, direction, startDate);
    }
}
