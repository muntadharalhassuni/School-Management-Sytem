/*  Requirement 2:

    The purpose of the Student class
        is to carry data related to one student.

*   1.Create a class Student with the private member variables
*       sEmail,sName,sPass,sCourses
*   2.The first constructor takes no parameters,
*       and it initializes every member to an initial value.
*   3. The second constructor must initialize every private member
        with a parameter provided to the constructor.
*   4. Must have GETTERS and SETTERS methods.
*
*
* */


package jpa.entitymodels;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Student {


    @Id
    @Column(name = "email")
    private String sEmail;


    @Basic
    @Column(name = "name")
    private String sName;


    @Basic
    @Column(name = "password")
    private String sPass;

    @ManyToMany
    @JoinTable(name = "StudentCourse",
            joinColumns = @JoinColumn(name = "email", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Course> sCourses =  new ArrayList<>();




    public Student() {
        this.sEmail = "";
        this.sName = "";
        this.sPass = "";
        this.sCourses = new ArrayList();
    }

    public Student(String sEmail, String sName, String sPass, List sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List getsCourses() {
        return sCourses;
    }

    public void setsCourses(List sCourses) {
        this.sCourses = sCourses;
    }

    @Override
    public String toString(){
        return "Student{" +
                "sEmail ='" + sEmail + '\'' +
                ", sName ='" + sName + '\''+
                ", sPass='" + sPass + '\'' +
                '}';

    }
}


