package com.ace.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ace.StudentException.DAOException;
import com.ace.dao.StudentDao;
import com.ace.entity.SortStudentByMarks;
import com.ace.entity.Student;
import com.ace.entity.Students;
import com.ace.entity.Subject;


@Repository
public class StudentDaoImpl implements StudentDao{
	private static final Logger log = Logger.getLogger(StudentDaoImpl.class.getName());
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public void getStudentFromXml(String fileName) {
		deleteAll();
		Students students = new Students();
		Transaction transaction = null;
		Session session = this.sessionFactory.openSession();
		try {
			File newFile = new File(fileName);
			transaction = session.beginTransaction();

			JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			students = (Students) jaxbUnmarshaller.unmarshal(newFile);
			System.out.println(students.getStudents().size());
			
			students.getStudents().forEach(student -> {
				session.merge(student);
				Integer totalMarks=student.getSubjectList().stream().mapToInt(subject -> subject.getSubjectMarks()).sum();
				student.setTotalMarks(totalMarks);
				if(totalMarks>=35){
					student.setPass(true);
				}
				
			});
			Collections.sort(students.getStudents(), Collections.reverseOrder(new SortStudentByMarks()));
			
			setStudentRank(students.getStudents());
			
			transaction.commit();
		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error Occourred while inserting Data " + e.getMessage());

		}finally{
			session.close();
		}

	}


	private void setStudentRank(List<Student> students) {

		students.forEach(student -> {
			
			int i = 0;
			student.setRankOfStudents(++i);
			System.out.println("Total Marks "+student.getTotalMarks() + " Ranks "+student.getRankOfStudents()  + " Pass "+student.isPass());
		});

	}
		
	



	@Override
	public void deleteAll() {
		Transaction transaction = null;
		Session session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Query query1 = session.createQuery("delete Subject");
		int result1 = query1.executeUpdate();
		Query query = session.createQuery("delete Student");
		int result = query.executeUpdate();
		System.out.println("result" + result + " result1" + result1);
		transaction.commit();
		session.close();

	}
	
	
	
	

}
