package com.ocm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ocm.bean.Enrollment;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EnrollmentDAOImpl implements EnrollmentDAO {
	
	private EntityManager entity;
	
	public EnrollmentDAOImpl() {
		super();
	}
	
	@Autowired
	public EnrollmentDAOImpl(EntityManager entity) {
		super();
		this.entity=entity;
	}
	
	@Override
	public void addenroll(Enrollment enrollment) {
		try {
			entity.persist(enrollment);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Enrollment> getallenroll() {
		try {
			return (List<Enrollment>) entity.createQuery("select enroll from Enrollment enroll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}
	
	@Override
	public Enrollment getenroll(int id) {
		try {
			return entity.find(Enrollment.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Enrollment();
	}
	
	

}
