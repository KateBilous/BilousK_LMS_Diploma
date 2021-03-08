package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Group;
import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.model.StudentDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryStudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(Storage.getInstance().getStudents().values());
    }

    @Override
    public Student saveStudent(Student student) {
        int newId = Storage.getInstance().getNewStudentId();
        student.setId(newId);
        return Storage.getInstance().getStudents().put(student.getId(), student);
    }


    @Override
    public Student getStudentById(int id) {
        return Storage.getInstance().getStudents().get(id);

    }

    @Override
    public boolean updateStudentById(Student student, int id) {
        Map<Integer, Student> students = Storage.getInstance().getStudents();
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return true;
        }
        return false;
    }



    @Override
    public boolean deleteStudentById(int id) {
        Map<Integer, Student> students = Storage.getInstance().getStudent();
        if (students.containsKey(id)) {
            students.remove(id);
            return true;
        }
        return false;
    }
}
