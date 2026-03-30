package com.hibernate_jpa.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hibernate_jpa.crud.dao.StudentDao;
import com.hibernate_jpa.crud.entity.Student;

import org.springframework.boot.CommandLineRunner;
import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {SpringApplication.run(CrudApplication.class, args);}

		@Bean
		public CommandLineRunner commandLineRunner(StudentDao studentDao) {
			return runner -> {
				//createStudent(studentDao);
				//readStudent(studentDao);
				//createMultipleStudents(studentDao);
				//queryForStudents(studentDao);
				//queryForStudentsByLastName(studentDao);

				updateStudent(studentDao);


			};
		}

		private void createStudent(StudentDao studentDao) {
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Pedro", "Santos", "pedro.santos@example.com");
			System.out.println("Saving the student...");
			studentDao.save(tempStudent);

			System.out.println("Saved student Generated id: " + tempStudent.getId());
		}


		private void createMultipleStudents(StudentDao studentDao) {
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Maria", "Silva", "maria.silva@example.com");
			Student tempStudent2 = new Student("João", "Souza", "joao.souza@example.com");
			Student tempStudent3 = new Student("Ana", "Oliveira", "ana.oliveira@example.com");

			System.out.println("Saving the students...");
			studentDao.save(tempStudent1);
			studentDao.save(tempStudent2);
			studentDao.save(tempStudent3);

			System.out.println("Saved students Generated ids: " + tempStudent1.getId() + ", " + tempStudent2.getId() + ", " + tempStudent3.getId());
		}

		private void readStudent(StudentDao studentDao) {

			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Carlos", "Mendes", "carlos.mendes@example.com");	
			System.out.println("Saving the student...");
			studentDao.save(tempStudent);
			
			int theId = tempStudent.getId();
			System.out.println("Saved student Generated id: " + theId);

			System.out.println("Retrieving student with id: " + theId);
			Student myStudent = studentDao.findById(theId);
			System.out.println("Found the student: " + myStudent);

			}

			private void queryForStudents(StudentDao studentDao) {
				List<Student> theStudents = studentDao.findAll();
				for(Student tempStudent : theStudents) {
					System.out.println(tempStudent);
				}
			}


			private void queryForStudentsByLastName(StudentDao studentDao) {
				List<Student> theStudents = studentDao.findByLastName("Santos");
				for(Student tempStudent : theStudents) {
					System.out.println(tempStudent);
				}
			}

			private void updateStudent(StudentDao studentDao) {
				int studentId = 1;
				System.out.println("Retrieving student with id: " + studentId);
				Student myStudent = studentDao.findById(studentId);
				System.out.println("Updating student...");

				myStudent.setFirstName("UpdatedName");
				
				studentDao.update(myStudent);

				System.out.println("Updated student: " + myStudent);
			}
}

