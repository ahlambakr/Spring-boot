package org.example.rest;

import jakarta.annotation.PostConstruct;
import org.example.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List <Student> theStudents;
    //define @PostConstructor to load the student data
    @PostConstruct
    public void loadData(){
          theStudents = new ArrayList<>();
              theStudents.add(new Student ("ahlam" ,"bakkr") );
              theStudents.add(new Student("mohamed" ,"bakkr")) ;

        }
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }
    @GetMapping ("/students/{studentId}")

    public Student getStudent(@PathVariable int studentId ){
    // check the studentId again list size
        if(studentId >= theStudents.size()  || studentId  < 0 )
            throw new StudentNotFoundException( "student id not found" + studentId );
        return theStudents.get(studentId) ;
    }

  /*  @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExeption (StudentNotFoundException exc){
//  create student error response
      StudentErrorResponse error = new StudentErrorResponse() ;
      error.setStatus(HttpStatus.NOT_FOUND.value());
      error.setMessage(exc.getMessage());
      error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    */


    // handle generic exception all execption
   /* @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExcption (Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse() ;
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
*/


}
