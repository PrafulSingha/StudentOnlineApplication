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
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="STUDENT_ID")
	private Set<Subject> subjects=new HashSet<Subject>();
	
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
	
	public Set<Subject> getSubjectList() {
		return subjects;
	}
	@XmlElement(name="Subject" , type=Subject.class)
	@XmlElementWrapper(name="subjects")
	public void setSubjectList(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
}
