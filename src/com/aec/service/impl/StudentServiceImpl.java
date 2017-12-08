package com.aec.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.entity.Student;
import com.aec.dao.StudentDao;
import com.aec.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentDao studentDao;
	
	
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	@Transactional
	public void getStudentFromXml(String fileName) {
			this.studentDao.getStudentFromXml(fileName);
	}

}
