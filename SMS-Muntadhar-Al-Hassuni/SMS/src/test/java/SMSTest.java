import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SMSTest {

    @Test
    public void loginIsTrue(){
        StudentService studentService = new StudentService();
        boolean isTrue = studentService.validateStudent("hluckham0@google.ru","X1uZcoIh0dj");
        Assert.assertTrue(isTrue);
    }
    @Test
    public void loginIsFalse(){
        StudentService studentService = new StudentService();
        boolean isFalse = studentService.validateStudent("wrong@perscholas.org","wrong");
        Assert.assertFalse(isFalse);
    }

}
