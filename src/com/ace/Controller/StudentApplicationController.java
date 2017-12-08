package com.ace.Controller;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ace.entity.Student;
import com.aec.service.StudentService;

@Controller
public class StudentApplicationController {
	private static final Logger log = Logger.getLogger(StudentApplicationController.class.getName());
	
	private StudentService studentService;
	
	
	
	
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value="/student/add",method=RequestMethod.POST)
	public void getStudentFromXml(String fileName){
		this.studentService.getStudentFromXml(fileName);
	}




	public static void main(String[] args) {
		//ExecutorService executor = Executors.newFixedThreadPool(5);
		
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
