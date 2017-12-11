/**
 * 
 */
package com.ace.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pku160
 *
 */

@XmlRootElement
@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	@Column(name="STUDENT_NAME")
	private String studentName;
	@Column(name="STUDENT_CLASS")
	private int studentClass;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="STUDENT_SUBJECT" , joinColumns={@JoinColumn(name="ID")},inverseJoinColumns={@JoinColumn(name="SUBJECT_ID")})
	@ElementCollection(targetClass=Subject.class)
	private Set<Subject> subjects=new HashSet<Subject>(0);
	
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
	public void setSubjectList(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
}
