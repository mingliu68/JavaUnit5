package com.education;

import java.util.ArrayList;
import java.util.List;


public class StudentDataObject {
    
    private List<Student> students = new ArrayList<>();

    public void addNewStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    
}
