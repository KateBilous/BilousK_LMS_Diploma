package com.bilous.BK_LMS_diploma.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public  class User {

    private Integer id;
    protected String firstName;
    protected String lastName;
    protected Date dateOfBirth;

    //private int id;


    public User(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                dateOfBirth.equals(user.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }
}
