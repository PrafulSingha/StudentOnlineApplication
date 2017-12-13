package com.ace.service;

import com.ace.StudentException.ServiceException;

public interface StudentService {
	
	public void getStudentFromXml(String fileName) throws ServiceException;

}
