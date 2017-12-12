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
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:/spring-servlet.xml");
		StudentService student=context.getBean(StudentServiceImpl.class);
		student.getStudentFromXml("C:\\student2.xml");
		/*StudentDao studentDao=new StudentDaoImpl();
		studentDao.getStudentFromXml("C:\\student2.xml");*/
		
		/*Students students=new Students();
		students.setStudents(new ArrayList<Student>());
		for(int i=0 ; i < 100; i++) {
			Student student1 = new Student();
			student1.setStudentId(i+1);
			student1.setStudentName("Ram");
			student1.setStudentClass(5+i%2);
			Subject s1 = new Subject();
			s1.setSubjectId(1);
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

		jaxbMarshaller.marshal(students, new FileOutputStream("C:\\student2.xml"));
		jaxbMarshaller.marshal(students, System.out);
		
		*/
		
		/*
		try {
			Student student1 = new Student();
			student1.setStudentId(1);
			student1.setStudentName("Ram");
			student1.setStudentClass(5);
			Subject s1 = new Subject();
			s1.setSubjectId(1);
			s1.setSubjectMarks(60);
			s1.setSubjectName("Maths");
			Subject s2 = new Subject();
			s2.setSubjectId(2);
			s2.setSubjectMarks(70);
			s2.setSubjectName("Physics");
			Set<Subject> subjects = new HashSet<Subject>();

			subjects.add(s1);
			subjects.add(s2);
			student1.setSubjectList(subjects);

			File newFile = new File("C:\\file.xml");

			JAXBContext jaxbContext1;

			jaxbContext1 = JAXBContext.newInstance(Student.class);

			Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(student1, newFile);
			jaxbMarshaller.marshal(student1, System.out);

		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error Occourred " + e.getMessage());
		}

	*/}

}
