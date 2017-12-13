package com.ace.Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ace.entity.Student;
import com.ace.entity.Students;
import com.ace.entity.Subject;

public class XmlMarshallingController {

	private static final Logger log = Logger.getLogger(XmlMarshallingController.class.getName());

	public static void main(String[] args) throws JAXBException,
			FileNotFoundException {

		Students students = new Students();
		students.setStudents(new ArrayList<Student>());
		for (int i = 0; i < 100; i++) {
			Student student1 = new Student();
			student1.setStudentId(i + 1);
			student1.setStudentName("Ram");
			student1.setStudentClass(5 + i % 2);
			Subject s1 = new Subject();
			s1.setSubjectMarks(60 + i % 2 + i / 10);
			s1.setSubjectName("Maths");
			Subject s2 = new Subject();
			s2.setSubjectMarks(40 + i % 2 + i / 10);
			s2.setSubjectName("Physics");
			Set<Subject> subjects = new HashSet<Subject>();
			subjects.add(s1);
			subjects.add(s2);
			student1.setSubjectList(subjects);
			students.getStudents().add(student1);
		}

		JAXBContext jaxbContext1;

		jaxbContext1 = JAXBContext.newInstance(Students.class);

		Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(students, new FileOutputStream(
				"C:\\astudent1.xml"));
		jaxbMarshaller.marshal(students, System.out);
		
		log.log(Level.INFO, "Your xml is created " );

	}

}
