package com.education;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private String subject;
    private String semester;
    private Boolean active = true;
    private List<String> students = new ArrayList<>();
    
    public Class (String name, String subject) {
        this.name = name;
        this.subject = subject;
        this.semester = null;    
    }

    public Class (String name, String subject, String semester) {
        this.name = name;
        this.subject = subject;
        this.semester = semester;
    }

    public String getClassName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getSemester() {
        return semester;
    }

    public List<String> getStudentsInClass() {
        return students;
    }

    public void markInactive() {
        active = false;
    }

    public void addStudentToClass(String studentName) {
        this.students.add(studentName);
    }

}
