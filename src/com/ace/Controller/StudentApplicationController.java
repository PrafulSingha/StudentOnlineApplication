package com.ace.Controller;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ace.entity.Student;

public class StudentApplicationController {
	private static final Logger log = Logger.getLogger(StudentApplicationController.class.getName());
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		try {
		
			File newFile =new File("C:\\file.xml");
		
			JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student) jaxbUnmarshaller.unmarshal(newFile);
			log.log(Level.INFO,  "Student Info " +student);
			
		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error Occourred "+e.getMessage());
		
		} 
		
	}

}
