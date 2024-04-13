package mega.portal.springbootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

  @Autowired
  private StudentRepo studentRepo;

  @PostMapping("/")
  public ResponseEntity<Student> createStudent(
      @RequestBody Student student
  ) {
    return ResponseEntity.ok(studentRepo.save(student));
  }

  @GetMapping("/")
  public ResponseEntity<Iterable<Student>> getStudents() {
    return ResponseEntity.ok(studentRepo.findAll());
  }
}
