package com.ace.dao.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ace.Controller.StudentApplicationController;
import com.ace.dao.StudentDao;
import com.ace.entity.Student;
import com.ace.entity.Students;


@Repository
public class StudentDaoImpl implements StudentDao{
	private static final Logger log = Logger.getLogger(StudentApplicationController.class.getName());

	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public void getStudentFromXml(String fileName) {
		Students students = null;
		Transaction transaction = null;
		Session session = this.sessionFactory.openSession();
		try {
			File newFile = new File(fileName);
			transaction = session.beginTransaction();

			JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			students = (Students) jaxbUnmarshaller.unmarshal(newFile);
			
			
			for(Student student:students.getStudents()){
				session.save(student);
			}
			
			transaction.commit();
		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error Occourred " + e.getMessage());

		}finally{
			session.close();
		}

	}
	
	

}
