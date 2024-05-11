package com.ocm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocm.bean.Course;
import com.ocm.bean.Enrollment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public interface EnrollmentDAO {

	public void addenroll(Enrollment enrollment);
	
	List<Enrollment> getallenroll();
	
	public Enrollment getenroll(int id);
	
	
}
