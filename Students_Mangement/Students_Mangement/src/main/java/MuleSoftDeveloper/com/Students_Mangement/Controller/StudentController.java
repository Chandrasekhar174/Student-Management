package MuleSoftDeveloper.com.Students_Mangement.Controller;


import MuleSoftDeveloper.com.Students_Mangement.Model.Students;
import MuleSoftDeveloper.com.Students_Mangement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students/")
@Validated
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Students> allStudent()
    {
        return studentService.allStudent();
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Students>> getStudentInfo(@PathVariable Long id )
    {
        return studentService.studentInfo(id);
    }
    @PostMapping("/add")
    public void addStudent(@RequestBody Students students)
    {
        studentService.addStudent(students);
    }
    @PutMapping("/id")
    public ResponseEntity<String> updateData(@RequestParam Long id,@RequestParam String updateEmailId)
    {
        return studentService.updateData(id,updateEmailId);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        return studentService.deleteStudent(id);
    }
}
