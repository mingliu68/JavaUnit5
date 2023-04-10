package com.education;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassDataObject {

    
    // set initial classes
    private Class algebra = new Class("Algebra", "math");
    private Class calculus = new Class("Calculus", "math");
    private Class spanish = new Class("Spanish", "language");
    private List<Class> classes = Arrays.asList(algebra, calculus, spanish);

    public void addClass(Class classObj) {
        classes.add(classObj);
    }

    public List<Class> getAllClasses() {
        return classes;
    }


    public Class getClassObj(String className) {
        for(Class classObj : classes) {
            if(classObj.getClassName().equals(className)) {
                return classObj;
            }
        }
        return null;
    }

    public List<Class> getClassBySubject(String subject) {
        List<Class> classesInSubject = new ArrayList<>();
        
        for(Class classObj: classesInSubject) {
            if(classObj.getSubject().equals(subject)) {
                classesInSubject.add(classObj);
            }
        }

        return classesInSubject;
    }

    public void markInactive(Class classObj) {
        classObj.markInactive();
    }

}
