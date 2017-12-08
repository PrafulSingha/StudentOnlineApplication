package com.aec.dao.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ace.Controller.StudentApplicationController;
import com.ace.entity.Student;
import com.aec.dao.StudentDao;

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
		Student student = null;
		try{
		File newFile =new File("C:\\file.xml");
		
		JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		student = (Student) jaxbUnmarshaller.unmarshal(newFile);
		log.log(Level.INFO,  "Student Info " +student);
		
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(student);
		session.close();
		
		
	} catch (JAXBException e) {
		log.log(Level.SEVERE, "Error Occourred "+e.getMessage());
	
	} 
		
	}
	
	

}
