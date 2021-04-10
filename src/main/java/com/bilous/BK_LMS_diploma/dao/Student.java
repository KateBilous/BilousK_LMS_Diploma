package com.bilous.BK_LMS_diploma.dao;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends User {

    private Group group;


    public Student(String firstName, String lastName, LocalDate dateOfBirth, Group group) {
        super(firstName, lastName, dateOfBirth);
        this.group = group;

    }


    public Group getGroup() {
        return group;
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", group=" + group +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), group);
    }
}
