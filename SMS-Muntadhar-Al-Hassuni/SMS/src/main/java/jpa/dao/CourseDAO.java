/*
Requirement 3:

Create another service as CourseDAO
    This interface is going to have the following method
        getAllCourses();

*/
package jpa.dao;
import jpa.entitymodels.Course;
import java.util.List;

public interface CourseDAO {

    List<Course> getAllCourses();

}
