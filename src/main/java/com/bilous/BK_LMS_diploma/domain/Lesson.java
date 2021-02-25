package com.bilous.BK_LMS_diploma.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lesson {

    private Group group;
    private String topic;
    private String materials;

    Set<HomeWork> homeWork;

    public Lesson(Group group, String topic, String materials) {
        this.group = group;
        this.topic = topic;
        this.materials = materials;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "group=" + group +
                ", topic='" + topic + '\'' +
                ", materials='" + materials + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return group.equals(lesson.group) &&
                topic.equals(lesson.topic) &&
                materials.equals(lesson.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, topic, materials);
    }
}


