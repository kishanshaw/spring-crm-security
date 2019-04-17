package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
				//create Session Factory 
				SessionFactory factory=  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create Session 
				Session session= factory.getCurrentSession();
				
				try{
					//start the transaction
					System.out.println("Begin the transaction ");
					session.beginTransaction();
					
					// Performing a bulk update
					int result = session.createQuery("delete from Student where id = 2").executeUpdate();
					
					//commit the transaction
					System.out.println("Commit the transaction");
					session.getTransaction().commit();
					
				}
				finally{
					factory.close();
					
				}

	}

}
