/**
 * 
 */
package com.ace.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pku160
 *
 */
@XmlRootElement
public class Subject {
	
	private int subjectId;
	private String subjectName;
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
