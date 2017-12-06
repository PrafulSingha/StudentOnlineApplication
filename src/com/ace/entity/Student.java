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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentClass;
		result = prime * result + studentId;
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result
				+ ((subjectList == null) ? 0 : subjectList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentClass != other.studentClass)
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (subjectList == null) {
			if (other.subjectList != null)
				return false;
		} else if (!subjectList.equals(other.subjectList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName="
				+ studentName + ", studentClass=" + studentClass
				+ ", subjectList=" + subjectList + "]";
	}
	
	
	
	
}
