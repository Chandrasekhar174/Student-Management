package MuleSoftDeveloper.com.Students_Mangement.Service;

import MuleSoftDeveloper.com.Students_Mangement.Model.Students;
import MuleSoftDeveloper.com.Students_Mangement.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private IStudentRepo studentRepo;


    public ResponseEntity<Optional<Students>> studentInfo(Long id) {

        Optional<Students> student;
        student = studentRepo.findById(id);
        return ResponseEntity.ok(student);
    }

    public void addStudent(Students students) {
        studentRepo.save(students);
        
    }

    public ResponseEntity<String> updateData(Long id, String updateEmailId) {

        Optional<Students>optstudent=studentRepo.findById(id);
        if(optstudent.isPresent())
        {
            Students student=optstudent.get();
            student.setEmailId(updateEmailId);
            return ResponseEntity.ok("Update successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not Found");
    }

    public ResponseEntity<String> deleteStudent(Long id) {
        Optional<Students> optstudent=studentRepo.findById(id);
        if(optstudent.isPresent())
        {
            Students student=optstudent.get();
            studentRepo.delete(student);
            return ResponseEntity.ok("Delete Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not Found");

    }

    public List<Students> allStudent() {
        return studentRepo.findAll();
    }
}
