package jpa.mainrunner;
import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

    private Scanner sin;
    private StringBuilder sb;
    private String email;

    private CourseService courseService;
    private static StudentService studentService;
    private Student currentStudent;

    public SMSRunner() {
        sin = new Scanner(System.in);
        sb = new StringBuilder();
        courseService = new CourseService();
        studentService = new StudentService();
    }

    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();

    }

    private void run() {
        switch (menu1()) {
            case 1:
                if (studentLogin()) {
                    registerMenu();
                }
                break;
            case 2:
                out.println("Goodbye!");
                break;
            default:
        }
    }

    private int menu1() {
        sb.append("\n1.Student Login\n" +
                "2. Quit Application\n" +
                "Please Enter Selection: ");

        out.print(sb);
        sb.delete(0, sb.length());
        return sin.nextInt();
    }
    private boolean studentLogin() {
        boolean retValue = false;
        out.print("Enter your email address: ");
        email = sin.next();
        out.print("Enter your password: ");
        String password = sin.next();


        Student student = studentService.getStudentByEmail(email);


        if(student == null){
            out.println("User not found");
            System.exit(0);
        }
        currentStudent = student;

        if (currentStudent != null & currentStudent.getsPass().equals(password)) {
            List<Course> courses = studentService.getStudentCourses(email);
            out.println("MyClasses");
            for (Course course : courses) {

                out.printf("%-3s %-30s %-30s\n", "ID", "Course", "Instructor");
                out.printf("%-3s %-30s %-30s\n", course.getcId(),course.getcName(),course.getcInstructorName());
            }
            retValue = true;
        } else {
            out.println("User Validation failed. GoodBye!");
        }
        return retValue;
    }
    private void registerMenu() {
        sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        out.print(sb);
        sb.delete(0, sb.length());

        switch (sin.nextInt()) {
            case 1:
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(email);
                allCourses.removeAll(studentCourses);
                out.printf("%3s%30s%30s\n", "ID", "Course", "Instructor");

                for (Course course : allCourses) {
                    out.printf("%3s %30s %30s\n", course.getcId(),course.getcName(),course.getcInstructorName());

                }
                out.println();
                out.print("Enter Course Number: ");
                Integer number = sin.nextInt();

                if (number != null) {
                    studentService.registerStudentToCourse(email,number);
                    List<Course> sCourses = studentService.getStudentCourses(email);
                    out.println("MyClasses");

                    for (Course course : sCourses) {
                        out.println(course);
                    }
                }
                break;
            case 2:
            default:
                out.println("Goodbye!");
        }
    }
}


