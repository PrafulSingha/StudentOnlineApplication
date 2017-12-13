package com.ace.dao;

import com.ace.StudentException.DAOException;

public interface StudentDao {
	
	public void getStudentFromXml(String fileName) throws DAOException ;
	
	public void deleteAll();

}
