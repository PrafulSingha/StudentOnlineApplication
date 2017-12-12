package com.ace.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "students")
public class Students {
	
	@XmlElement(name = "Student")
    private List<Student> students = new ArrayList<Student>();

	public Students() {
		
	}

	public Students(List<Student> students) {
		super();
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
     

}
