package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.jdbc.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create Session Factory 
		SessionFactory factory=  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create Session 
		Session session= factory.getCurrentSession();
		
		try{
			
			//start the transaction
			System.out.println("Begin the transaction ");
			session.beginTransaction();
			
			//Display Students
			List<Student> students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			displayStudents(students);
			
			System.out.println("Inserting the new student");
			Student student  = new Student("Kunal", "Jaiswal", "kunaljais@gmail.com");
			session.save(student);
			
			//commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
			
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student tempstudent : students){
			System.out.println(tempstudent);
			
		}
	}

}
