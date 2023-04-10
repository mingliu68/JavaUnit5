package com.education;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructorDataObject {
    List<Instructor> instructors = new ArrayList<>();

    public void addNewInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructors;
    }

  

}
