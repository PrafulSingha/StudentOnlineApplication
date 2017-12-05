package com.ace.XmlParser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ace.entity.Student;

public class XmlParser {
	
	public static void main(String[] args) {
		
		Student student1=new Student();
		student1.setStudentId(1);
		student1.setStudentName("Ram");
		student1.setStudentClass("5");
		
		try {
		
			File newFile =new File("C:\\file.xml");
			
			JAXBContext jaxbContext1 = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(student1, newFile);
			jaxbMarshaller.marshal(student1, System.out);
			
			
			
		/*
			JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student) jaxbUnmarshaller.unmarshal(newFile);
			System.out.println(student);*/
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
