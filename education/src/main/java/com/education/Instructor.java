package com.education;

import java.util.Arrays;
import java.util.List;

public class Instructor {
    private String name;
    private String[] classes;

    public Instructor(String name, String[] classes) {
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name; 
    }

    public List<String> getClasses() {
        return Arrays.asList(classes);
    }


}
