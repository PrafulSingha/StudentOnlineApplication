package com.ace.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ace.StudentException.ServiceException;
import com.ace.dao.StudentDao;
import com.ace.dao.impl.StudentDaoImpl;

public class StudentApplicationTests {
	private static StudentDao studentDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentDao=new StudentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentDao=null;
	}

	
	@Test
	public void testisNull() throws ServiceException {
		
		String s=studentDao.getJsonFiles("1");
		
		assertNotNull(s);
		
		
	}
	
	@Test
	public void testisequal() throws ServiceException {
		
		String s=studentDao.getJsonFiles("1");
		
		assertEquals("1".contains("1"), s.contains("1"));
		
		
	}


}
