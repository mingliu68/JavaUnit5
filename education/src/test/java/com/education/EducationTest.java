package com.education;

// import static org.junit.Assert.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.never;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import business.EducationBusinessImpl;




public class EducationTest 
{
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock 
    private StudentDataObject studentDataObjectMock;

    @Mock 
    private InstructorDataObject instructorDataObjectMock;

    @Mock 
    private ClassDataObject classDataObjectMock;

    @InjectMocks
    private EducationBusinessImpl educationBusinessImpl;

    @Captor
    private ArgumentCaptor<Class> classArgumentCaptor;



    @Test
    public void testStudentsInClassBySubject() {
        //Given
        Student joyMa = new Student("Joy Ma", "Spanish");
        Student julioHernandez = new Student("Julio Hernandez", "Algebra");
        Student jennyJones = new Student("Jenny Jones", "Calculus");
        List<Student> students = Arrays.asList(joyMa, julioHernandez, jennyJones);
  

        given(studentDataObjectMock.getAllStudents()).willReturn(students);

        //When
        List<String> studentsInMathClass = educationBusinessImpl.getStudentsBySubject("math");


        //Then
        
        assertThat(studentsInMathClass.size(), is(2));
        assertThat(studentsInMathClass, hasItems("Julio Hernandez","Jenny Jones"));
    }

    @Test
    public void testMarkInactive() {
        // Given
        Class geometry = new Class("Geometry", "math", "Summer 2022");
        Class envSci = new Class("Environmental Science", "science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "english", "Spring 2023");
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObjectMock.getAllClasses()).willReturn(allClasses);

        //When

        educationBusinessImpl.markCurrentClassesInactive();

        //Then

        verify(classDataObjectMock).markInactive(geometry);
        verify(classDataObjectMock, Mockito.never()).markInactive(compLit);
        verify(classDataObjectMock, Mockito.never()).markInactive(envSci);
        verify(classDataObjectMock, Mockito.times(1)).markInactive(geometry);

    }

    @Test
    public void testMarkInactive_argumentCaptor() {
        //Given
        Class geometry = new Class("Geometry", "math", "Summer 2022");
        Class envSci = new Class("Environmental Science", "science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "english", "Spring 2023");
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObjectMock.getAllClasses()).willReturn(allClasses);

        //When
        educationBusinessImpl.markCurrentClassesInactive();

        //Then
        verify(classDataObjectMock).markInactive(classArgumentCaptor.capture());
        assertThat(classArgumentCaptor.getValue(), is(geometry));
    }

  
    @Test 
    public void testClassesByInstructor() {
        //Given
        Instructor teacher1 = new Instructor("Peter", new String[] {"Geometry", "Calculus", "Algebra"});
        Instructor teacher2 = new Instructor("Sandy", new String[] {"Comparative Literature"});
        Instructor teacher3 = new Instructor("Julio", new String[] {"Spanish"});
        List<Instructor> instructors = Arrays.asList(teacher1, teacher2, teacher3);

        given(instructorDataObjectMock.getAllInstructors()).willReturn(instructors);

        //When
        List<String> classes = educationBusinessImpl.getClassesByInstructor("Peter");


        for(Instructor instructor : instructors) {
            System.out.println(instructor.getName() + ", " + instructor.getClasses());
        }
        
        for(String className : classes) {
            System.out.println(className);
        }

        System.out.println(classes.size());

        //Then
        assertThat(instructorDataObjectMock.getAllInstructors().size(), is(3));
        assertThat(classes.size(), is(3));
        
    }

    @Test
    public void testStudentsInClassByClassId() {
        //Given
        Class geometry = new Class("Geometry", "math", "Summer 2022");
        Class envSci = new Class("Environmental Science", "science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "english", "Spring 2023");
        Class calculus = new Class("Calculus", "math", "Spring 2023");
        Class algebra = new Class("Algebra", "math", "Spring 2023");
        Class spanish = new Class("Spanish", "language", "Spring 2023");
        spanish.addStudentToClass("Joy Ma");
        spanish.addStudentToClass("Bob Lee");
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit, calculus, algebra, spanish);

        given(classDataObjectMock.getAllClasses()).willReturn(allClasses);

        //When
        List<String> students = educationBusinessImpl.getStudentsInClass("Spanish");

        //Then
        assertThat(students.size(), is(2));
        assertThat(students, hasItems("Joy Ma", "Bob Lee"));
    }
}
