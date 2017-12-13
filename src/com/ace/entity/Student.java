/**
 * 
 */
package com.ace.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author pku160
 *
 */


@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@Column(name="STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@Column(name="STUDENT_CLASS")
	private int studentClass;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="STUDENT_ID")
	private Set<Subject> subjects=new HashSet<Subject>();
	
	public int getStudentId() {
		return studentId;
	}
	@XmlAttribute
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
	
	public Set<Subject> getSubjectList() {
		return subjects;
	}
	@XmlElement(name="Subject" , type=Subject.class)
	@XmlElementWrapper(name="subjects")
	public void setSubjectList(Set<Subject> subjects) {
		this.subjects = subjects;
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
				+ ((subjects == null) ? 0 : subjects.hashCode());
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
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}
	
	
	
	
}
