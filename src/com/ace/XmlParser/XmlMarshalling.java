package com.ace.XmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ace.entity.Student;
import com.ace.entity.Subject;

public class XmlMarshalling {

	public static void main(String[] args) {
		try {
		Student student1=new Student();
			student1.setStudentId(1);
			student1.setStudentName("Ram");
			student1.setStudentClass(5);
			Subject s1=new Subject();
			s1.setSubjectId(1);
			s1.setSubjectMarks(60);
			s1.setSubjectName("Maths");
			Subject s2=new Subject();
			s2.setSubjectId(2);
			s2.setSubjectMarks(70);
			s2.setSubjectName("Physics");
			List<Subject> subjects =new ArrayList<Subject>();
		  		
		 	subjects.add(s1);
		 	subjects.add(s2);
		 	student1.setSubjectList(subjects);
			
			File newFile =new File("C:\\file.xml");
				
				JAXBContext jaxbContext1;
				
					jaxbContext1 = JAXBContext.newInstance(Student.class);
				
				Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
			// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
				jaxbMarshaller.marshal(student1, newFile);
				jaxbMarshaller.marshal(student1, System.out);
				
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
