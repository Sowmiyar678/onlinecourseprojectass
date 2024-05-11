package com.ocm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ocm.bean.Course;
import com.ocm.bean.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public interface UserDAO  {

	public void adduser(User user);
	
	List<User> getalluser();
	
	
	 
}
