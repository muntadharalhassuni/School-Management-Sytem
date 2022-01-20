/*  Requirement 4:

Create a Course Service which implements the respective DAOs

getAllCourses
–This method takes no parameter and returns every Course in the table.

* */
package jpa.service;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CourseService implements CourseDAO {
    private EntityManagerFactory mFactory;
    private EntityManager mgr;

    public void setUpDataBase(){
        mFactory = Persistence.createEntityManagerFactory("java");
        mgr = mFactory.createEntityManager();
    }
    public void closeDataBase(){
        mgr.close();
        mFactory.close();
    }


    @Override
    public List<Course> getAllCourses() {
        setUpDataBase();

        try {
            Query query = mgr.createQuery("select c from Course c");
            List coursesList = query.getResultList();
            return coursesList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
             closeDataBase();
        }
    }


}

