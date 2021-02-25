package com.bilous.BK_LMS_diploma.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HomeWork  {

    private HomeTask homeTasks;
    private int result;


    public HomeWork(HomeTask homeTasks, int result) {
        this.homeTasks = homeTasks;
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "homeTasks=" + homeTasks +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWork homeWork = (HomeWork) o;
        return result == homeWork.result &&
                homeTasks.equals(homeWork.homeTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTasks, result);
    }
}
