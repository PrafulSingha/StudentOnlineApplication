package com.ace.dao.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class StudentDaoImpl implements StudentDao {
	private static final Logger log = Logger.getLogger(StudentDaoImpl.class
			.getName());
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void getStudentFromXml(String fileName) throws DAOException {
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

			students.getStudents().forEach(
					student -> {
						session.merge(student);
						Integer totalMarks = student.getSubjectList().stream()
								.mapToInt(subject -> subject.getSubjectMarks())
								.sum();
						student.setTotalMarks(totalMarks);
						if (totalMarks >= 35) {
							student.setPass(true);
						}

					});
			Collections.sort(students.getStudents(),
					Collections.reverseOrder(new SortStudentByMarks()));

			setStudentRankinJson(students.getStudents());

			transaction.commit();
			session.close();
		} catch (JAXBException e) {
			log.log(Level.SEVERE,
					"Error Occourred while inserting Data " + e.getMessage());
			throw new DAOException("Error Occourred while inserting Data "
					+ e.getMessage());
		}

	}

	private void setStudentRankinJson(List<Student> students)
			throws DAOException {
		int i = 0;

		ExecutorService service = Executors.newFixedThreadPool(Runtime
				.getRuntime().availableProcessors());
		for (Student student : students) {
			if (student.isPass()) {
				student.setRankOfStudents(++i);
				System.out.println("Total Marks " + student.getTotalMarks()
						+ " Ranks " + student.getRankOfStudents() + " Pass "
						+ student.isPass());
			} else {
				student.setRankOfStudents(0);
			}
			service.submit(new Runnable() {
				public void run() {
					ObjectMapper objMap = new ObjectMapper();

					try {
						objMap.writeValue(new File(student.getStudentName()
								+ "_" + student.getStudentId() + ".json"),
								student);
					} catch (IOException e) {
						log.log(Level.SEVERE,
								"Error Occourred while Writing Json Data "
										+ e.getMessage());
					}

				}
			});

		}

	}

	public String getJsonFiles(String id) throws DAOException {
		File file = new File(System.getProperty("user.dir"));
		File[] files = file.listFiles();
		ObjectMapper objectMapper;
		Student student = null;
		String subjectDetails = " subjects ";
		try {
			for (File f : files) {

				if (f.getName()
						.contains(id) && f.getName().contains("_")) {

					byte[] jsonData = Files
							.readAllBytes(Paths.get(f.getName()));
					objectMapper = new ObjectMapper();
					student = objectMapper.readValue(jsonData, Student.class);
				}
			}
		} catch (IOException e) {
			log.log(Level.SEVERE,
					"Error Occourred while Reading Json File Data "
							+ e.getMessage());
			throw new DAOException(
					"Error Occourred while Reading Json File Data "
							+ e.getMessage());
		}
		for(Subject s:student.getSubjectList()){
			subjectDetails="["+subjectDetails+s.toString()+" , ";
		}
		subjectDetails=subjectDetails+"]";
		return student.toString() +subjectDetails;
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
