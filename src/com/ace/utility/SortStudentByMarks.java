package com.ace.utility;

import java.util.Comparator;

import com.ace.entity.Student;

public class SortStudentByMarks implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getTotalMarks()-o2.getTotalMarks();
	}

}
