package com.laizuozuoba.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.laizuozuoba.db.SqlSessionFactoryUtls;
import com.laizuozuoba.models.Student;

public class StudentBizImpl {
	public List<Student> queryStudent(Long id){
		List<Student> studentList = new ArrayList<Student>();
		SqlSession sqlSession = SqlSessionFactoryUtls.getSessionFactory().openSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			studentList = sqlSession.selectList("com.laizuozuoba.models.Student.selectStudent", map);
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
