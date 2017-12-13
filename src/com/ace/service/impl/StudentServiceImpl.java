package com.ace.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.StudentException.ServiceException;
import com.ace.dao.StudentDao;
import com.ace.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	private static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());
	
	private StudentDao studentDao;
	
	
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	@Transactional
	public void getStudentFromXml(String fileName) throws ServiceException {
			try {
				this.studentDao.getStudentFromXml(fileName);
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Error Occourred in Service " + e.getMessage());
				throw new ServiceException("Error Occourred in Service " + e.getMessage());
			}
	}

}
