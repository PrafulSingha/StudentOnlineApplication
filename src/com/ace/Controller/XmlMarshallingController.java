package com.ace.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;





import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ace.dao.StudentDao;
import com.ace.dao.impl.StudentDaoImpl;
import com.ace.entity.Student;
import com.ace.entity.Students;
import com.ace.entity.Subject;
import com.ace.service.StudentService;
import com.ace.service.impl.StudentServiceImpl;

public class XmlMarshallingController {

	//private static final Logger log = Logger.getLogger(XmlMarshallingController.class.getName());

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		
		
		
		//students.getStudents().forEach(student -> session.merge(student));
		Students students=new Students();
		students.setStudents(new ArrayList<Student>());
		for(int i=0 ; i < 100; i++) {
			Student student1 = new Student();
			student1.setStudentId(i+1);
			student1.setStudentName("Ram");
			student1.setStudentClass(5+i%2);
			Subject s1 = new Subject();
			s1.setSubjectMarks(60);
			s1.setSubjectName("Maths");
			Set<Subject> subjects=new HashSet<Subject>();
			subjects.add(s1);
			student1.setSubjectList(subjects);
			students.getStudents().add(student1);
		} 
		
		
		JAXBContext jaxbContext1;

		jaxbContext1 = JAXBContext.newInstance(Students.class);

		Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(students, new FileOutputStream("C:\\astudent1.xml"));
		jaxbMarshaller.marshal(students, System.out);
		
		
		}

}
