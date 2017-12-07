/**
 * 
 */
package com.ace.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pku160
 *
 */
@XmlRootElement
@Entity
@Table(name="SUBJECT")
public class Subject {
	@Id
	@Column(name="SUBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@Column(name="SUBJECT_MARKS")
	private int subjectMarks;
	
	private List<Student> studentList;
	
	@OneToMany(fetch=FetchType.LAZY)
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public int getSubjectId() {
		return subjectId;
	}
	@XmlAttribute
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	@XmlElement
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectMarks() {
		return subjectMarks;
	}
	@XmlElement
	public void setSubjectMarks(int subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	
	
	
}
