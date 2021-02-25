package com.bilous.BK_LMS_diploma.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Teacher  extends User{

    private String role;

    private Set<Group> groups;


    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String role) {
        super(firstName, lastName, dateOfBirth);
        this.role = role;
        this.groups = new HashSet<>();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addGroup(Group group){
        if (this.groups == null){
            this.groups = new HashSet<>();
        }
        groups.add(group);
    }

    public Set<Group> getGroups(){
        return this.groups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "role='" + role + '\'' +
                ", groups=" + groups +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "} " ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return role.equals(teacher.role) &&
                groups.equals(teacher.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }
}
