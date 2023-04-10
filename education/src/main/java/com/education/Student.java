package com.education;

public class Student {
    private String name;
    private String classTaken;

    public Student(String name, String classTaken) {
        this.name = name;
        this.classTaken = classTaken;
    }

    public String getName() {
        return name;
    }
    public String getClassTaken() {
        return classTaken;
    }
}
