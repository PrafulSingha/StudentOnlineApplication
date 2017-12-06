/**
 * 
 */
package com.ace.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pku160
 *
 */

@XmlRootElement
public class Student {
	
	private int studentId;
	private String studentName;
	private int studentClass;
	
	
	private List<Subject> subjectList;
	
	public int getStudentId() {
		return studentId;
	}
	@XmlElement
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	@XmlElement
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentClass() {
		return studentClass;
	}
	@XmlElement
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	@XmlElement(name="Subject" , type=Subject.class)
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
	
	
}
