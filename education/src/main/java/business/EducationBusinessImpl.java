package business;

import java.util.ArrayList;
import java.util.List;

import com.education.Class;
import com.education.ClassDataObject;
import com.education.Instructor;
import com.education.InstructorDataObject;
import com.education.Student;
import com.education.StudentDataObject;

public class EducationBusinessImpl {
    
    private StudentDataObject studentDataObject;
    private ClassDataObject classDataObject;
    private InstructorDataObject instructorDataObject;

    public List<String> getStudentsBySubject(String subject) {
        List<Student> allStudents = studentDataObject.getAllStudents();
        List<String> studentsInClass = new ArrayList<>();
        for(Student student : allStudents) {
            String classTaken = student.getClassTaken();
            if(subject.equals("math") && 
                (classTaken.equals("Algebra") || classTaken.equals("Calculus"))) {
                studentsInClass.add(student.getName());
            }
            if(subject.equals("language") && classTaken.equals("Spanish")) {
                studentsInClass.add(student.getName());
            } 
           
        }
        return studentsInClass;
    }

    public void markCurrentClassesInactive() {
        List<Class> allClasses = classDataObject.getAllClasses();
        String currentSem = "Summer 2022";
        for(Class classObj : allClasses) {
            if(classObj.getSemester().equals(currentSem)) {
                classDataObject.markInactive(classObj);
            }
        }
    }

    public List<String> getClassesByInstructor(String teacherName) {
        
        List<Instructor> allInstructors = instructorDataObject.getAllInstructors();
        List<String> classes = new ArrayList<>();

        for(Instructor instructor : allInstructors) {
            if(instructor.getName().equals(teacherName)) {
                classes = instructor.getClasses();
            }
        }
        return classes;
    }

    public List<String> getStudentsInClass(String className) {
        List<Class> allClasses = classDataObject.getAllClasses();
        List<String> students = new ArrayList<>();
        for(Class classObj: allClasses) {
            if(classObj.getClassName().equals(className)) {
                students = classObj.getStudentsInClass();
            }
        }
        return students;
    }



    
}
