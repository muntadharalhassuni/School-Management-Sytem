/*  Requirement 2:

    The purpose of the Course class
     is to carry data related to one Course

    1.Create a class Course with the private member variables
        cId,cName,cInstructorName
    2.The first constructor takes no parameters,
        and it initializes every member to an initial value.
    3.The second constructor must initialize every private member
        with a parameter provided to the constructor.
    4.Must have GETTERS and SETTERS methods.


* */


package jpa.entitymodels;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Course {

    @Id
    @Column(name = "id")
    private int cId;


    @Basic
    @Column(name = "name")
    private String cName;


    @Basic
    @Column(name = "instructor")
    private String cInstructorName;

    @ManyToMany(mappedBy = "sCourses")
    private List<Student> students = new ArrayList<>();



    public Course() {
        this.cName = "";
        this.cInstructorName = "";
    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    @Override
    public String toString() {

        return "\t"+ cId + "\t\t" + cName + "\t\t" + cInstructorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return cId == course.cId && Objects.equals(cName, course.cName) && Objects.equals(cInstructorName, course.cInstructorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, cName, cInstructorName);
    }
}
