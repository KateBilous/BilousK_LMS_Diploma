package com.bilous.BK_LMS_diploma.domain.model.inMemoryImpl;

import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.model.StudentDao;
import com.bilous.BK_LMS_diploma.persistence.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryStudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(Storage.getInstance().getStudent().values());
    }

    @Override
    public Student saveStudent(Student student) {
        Student savedStudent = buildStudentFromTemplate(student);
        int newId = Storage.getInstance().getNewStudentId();
        savedStudent.setId(newId);
        Storage.getInstance().getStudent().put(newId, savedStudent);
        return savedStudent;
    }

    private Student buildStudentFromTemplate(Student student) {
        Student newStudent = new Student(student.getFirstName(), student.getLastName(), student.getDateOfBirth(),
                student.getGroup());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setDateOfBirth(student.getDateOfBirth());
        newStudent.setGroup(student.getGroup());
        return newStudent;
    }

    @Override
    public Student getStudentById(int id) {
        return Storage.getInstance().getStudent().get(id);

    }

    @Override
    public boolean updateStudent(Student teacher) {
        int id = teacher.getId();
        Map<Integer, Student> students = Storage.getInstance().getStudent();
        if (students.containsKey(id)) {
            students.put(id, teacher);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateStudentById(Student student) {
        int id = student.getId();
        Map<Integer, Student> students = Storage.getInstance().getStudent();
        if (students.containsKey(id)) {
            students.put(id, student);
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
