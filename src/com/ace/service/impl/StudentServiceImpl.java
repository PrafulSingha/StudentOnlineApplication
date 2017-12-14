package com.ace.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.StudentException.ControllerException;
import com.ace.StudentException.DAOException;
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


	/*
	 * This method gets data from uploaded xml , create database entry and json files
	 * 
	*/
	@Override
	@Transactional
	public void getStudentFromXml(String fileName) throws ServiceException {
			try {
				this.studentDao.getStudentFromXml(fileName);
			} catch (DAOException e) {
				log.log(Level.SEVERE, "Error Occourred in Service " + e.getMessage());
				throw new ServiceException("Error Occourred in Service " + e.getMessage());
			}
	}


	/*
	 * This method gets checks if report is present for particular id
	 * 
	*/
	@Override
	public String getJsonFiles(String id) throws ServiceException {
		String jsonfile;
		try {
			jsonfile="Student with id "+id+" is " +"\n"+this.studentDao.getJsonFiles(id);
		} catch (ServiceException e) {
			log.log(Level.SEVERE, "Error Occourred in Service while getting json " + e.getMessage());
			throw new ServiceException("Error Occourred in Service while getting json " + e.getMessage()); 
		}
		return jsonfile;
	}

}
