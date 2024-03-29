package com.example.demo;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static com.example.demo.DAO.StudentDAO.*;

@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return  runner ->{
			//create one student
		//	createStudent(studentDAO);
			// create muliples student
		//	 createMultipleStudents(studentDAO);
			 //read student by id
		//	 readStudent (studentDAO) ;
			 
			// qeryForStudents (studentDAO);
		//	queryForStudentsByLastName (studentDAO) ;


        // update student
			//updateStudent (studentDAO) ;

			// delete student
			//deletStudent(studentDAO) ;
			//delete all students
			deleteAllStudents (studentDAO) ;

		};
}
private void deleteAllStudents (StudentDAO studentDAO) {
		int num = studentDAO.deleyeAll() ;

}

	private void deletStudent(StudentDAO studentDAO) {

		int studentId  = 2 ;
		studentDAO.delete(studentId);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get alist of students
		List <Student> theStudents = studentDAO.findByLastName("Public") ;

		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}


	}

	private void qeryForStudents(StudentDAO studentDAO) {
		//get list of students

		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private  void readStudent (StudentDAO studentDAO ){
	System.out.println("creating new student object");

	Student tempStudent = new Student("lol" , "lmao" , "lollmao2020@gmail.com") ;

	// save the student object
	System.out.println("saving student");
	studentDAO.save(tempStudent);

	//display id of the saved student
	int theId = tempStudent.getId();
	System.out.println("saved student. Generated id :" + tempStudent.getId());
	Student myStudent = studentDAO.findById(theId) ;
	System.out.println("from the student" +myStudent);



}
private void createStudent (StudentDAO studentDAO ) {
		// create student object
	System.out.println("creating new student object");

	Student tempStudent = new Student("paul" , "Doe" , "pauldao2020@gmail.com") ;

	// save the student object
	System.out.println("saving student");
	studentDAO.save(tempStudent);

	//display id of the saved student
	System.out.println("saved student. Generated id :" + tempStudent.getId());

}
	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

		private void updateStudent(StudentDAO studentDAO) {

			// retrieve student based on the id: primary key
			int studentId = 1;
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = studentDAO.findById(studentId);

			// change first name to "John"
			System.out.println("Updating student ...");
			myStudent.setFirstName("John");

			// update the student
			studentDAO.update(myStudent);

			// display the updated student
			System.out.println("Updated student: " + myStudent);
		}


}
