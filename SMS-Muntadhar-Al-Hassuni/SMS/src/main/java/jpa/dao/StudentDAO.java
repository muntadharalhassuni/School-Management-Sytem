/*  Requirement 3:

    Create an interface and call it StudentDAO
	    Interface is going to be having the following method declarations
            1.getAllStudents();
            2.getStudentByEmail();
            3.validateStudent();
            4.registerStudentToCourse()
            5.getStudentCourses()

* */
package jpa.dao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();
    Student getStudentByEmail(String sEmail);
    boolean validateStudent(String sEmail, String sPassword);
    void registerStudentToCourse(String sEmail, int cId);
    List<Course> getStudentCourses(String sEmail);

}
