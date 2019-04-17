package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.jdbc.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//create Session Factory 
		SessionFactory factory=  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create Session 
		Session session= factory.getCurrentSession();
		
		try{
			
			//use session object to save Java objects in the database
			System.out.println("Creating a student object");
			
			Student student  = new Student("Kishan", "Shaw", "kishanshaw29@gmail.com");
			
			//start the transaction
			System.out.println("Begin the transaction ");
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student object");
			session.save(student);
			
			//commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
			
		}
		
	}

}
