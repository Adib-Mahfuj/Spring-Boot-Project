package com.example.SpringBoot_RestApi.Controller;

import com.example.SpringBoot_RestApi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getsStudent(){
        Student student = new Student(
                1,
                "Adib",
                "Mahfuj"
        );
        //return  ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","Adib").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getstudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Adib","Mahfuj"));
        students.add(new Student(2,"Atik","Fahmin"));
        students.add(new Student(3,"Shakibul","Hasan"));
        students.add(new Student(4,"Arnob","Joy"));

        return ResponseEntity.ok(students);
    }

    //SPRING BOOT REST API with path variable
    //{id} - URI TEMPLATE VARIABLE
    @GetMapping("{id}")
    public ResponseEntity<Student> studentpathvariable(@PathVariable int id){
        Student student= new Student(id,"Adib","Mahfuj");
        return ResponseEntity.ok(student);
    }

    //SPRING BOOT REST API with multiple path variable
    @GetMapping("{id}/{first_name}/{last_name}")
    public ResponseEntity<Student> studentspathvariable(@PathVariable("id") int Student_Id,
                                        @PathVariable("first_name") String FirstName,
                                        @PathVariable("last_name") String LastName
    )
    {
        Student student = new Student(Student_Id,FirstName,LastName);
        return ResponseEntity.ok(student);
    }

    //SPRING BOOT REST API with Requestparam
    //http://localhost:8080/student/query?id=3&firstname=Adib&lastname=Mahfuj
    @GetMapping("query")
    public ResponseEntity<Student> studentrqparam(@RequestParam int id,
                                  @RequestParam String firstname,
                                  @RequestParam String lastname)
    {
        Student student = new Student(id,firstname,lastname);
        return ResponseEntity.ok(student);
    }

    //SPRING BOOT REST API that handles HTTP POST REQUEST - Creating new resource
    @PostMapping("create")
   // @ResponseStatus(HttpStatus.CREATED) // Returns 201 Created status
    public ResponseEntity<Student> createstudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //SPRING BOOT REST API that handles HTTP PUT REQUEST - Updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId )
    {
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        return ResponseEntity.ok(student);
    }

    //SPRING BOOT REST API that handles HTTP DELETE REQUEST - Deleting existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId)
    {
        return ResponseEntity.ok("Student deleted successfully!");
    }

}
