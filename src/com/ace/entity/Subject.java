/**
 * 
 */
package com.ace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author pku160
 *
 */

@Entity
@Table(name="STUDENT_SUBJECT")
public class Subject {
	@Id
	@Column(name="SUBJECT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@Column(name="SUBJECT_MARKS")
	private int subjectMarks;
	
	
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
