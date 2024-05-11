package com.ocm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ocm.bean.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {

	
	private EntityManager eman;
	
	public CourseDAOImpl() {
		super();
	}

	@Autowired
	public CourseDAOImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
	public void addcourse(Course course) {
		try {
			eman.persist(course);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

 @SuppressWarnings("unchecked")
 @Override
 public List<Course> getallcourse(){
	 try {
		 return (List<Course>)eman.createQuery("select course from Course course").getResultList();
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return new ArrayList<>();
 }
	
 @Override
 public Course getcourse(int id) {
	 try {
		 return eman.find(Course.class, id);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return new Course();
 }
//
//	@Override
//	public Course findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
