package com.ace.XmlParser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.ace.entity.Student;

public class XmlParser {
	
	public static void main(String[] args) {
		
		try {
		File file =new File("");
		
			JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
