package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
				//create Session Factory 
				SessionFactory factory=  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create Session 
				Session session= factory.getCurrentSession();
				
				try{
					
					//use session object to save Java objects in the database
					System.out.println("Creating a student object");
					
					Student student  = new Student("Daffodil", "Duck", "daffodilduck9@gmail.com");
					
					//start the transaction
					System.out.println("Begin the transaction ");
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the Student object");
					session.save(student);
					
					//commit the transaction
					System.out.println("Commit the transaction");
					session.getTransaction().commit();
					
					
					System.out.println("Retrieving the above object");
					System.out.println("Getting id of the object: " + student.getId());
					
					//Get a new session, start a transaction. retrieve the object and commit the transaction.
					
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					System.out.println("Getting Student with the id: "+student.getId());
					Student tempstudent = session.get(Student.class, student.getId()); 
					
					session.getTransaction().commit();
					
					System.out.println("Getting the student object: "+tempstudent);
					
					
				}
				finally{
					factory.close();
					
				}

	}

}
