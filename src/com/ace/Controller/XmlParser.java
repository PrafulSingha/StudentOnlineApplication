package com.ace.Controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ace.entity.Student;

public class XmlParser {
	
	public static void main(String[] args) {
			try {
		
			File newFile =new File("C:\\file.xml");
		
			JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student) jaxbUnmarshaller.unmarshal(newFile);
			System.out.println(student);
			
		} catch (JAXBException e) {
			System.out.println("Exception Ocuurred ");
		
		} 
		
	}

}
