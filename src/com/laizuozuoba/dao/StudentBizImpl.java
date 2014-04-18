package com.laizuozuoba.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.laizuozuoba.db.SqlSessionFactoryUtls;
import com.laizuozuoba.models.Student;

public class StudentBizImpl {
	public List<Student> queryStudent(Long id){
		List<Student> studentList = new ArrayList<Student>();
		SqlSession sqlSession = SqlSessionFactoryUtls.getSessionFactory().openSession();
		try {
			studentList = sqlSession.selectList("com.laizuozuoba.models.Student.selectStudent", id);
		}finally{
			sqlSession.close();
		}
		return studentList;
	}
	
	public static void main(String[] args){
		StudentBizImpl biz = new StudentBizImpl();
		List<Student> studentList = biz.queryStudent(1L);
		for(Student student : studentList){
			System.out.println(student.getSname());
		}
	}
}
