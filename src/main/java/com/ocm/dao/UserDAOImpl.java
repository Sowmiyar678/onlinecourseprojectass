package com.ocm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ocm.bean.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	private EntityManager entity;
	
	public UserDAOImpl() {
		super();
	}
	
	@Autowired
	public UserDAOImpl(EntityManager entity) {
		super();
		this.entity=entity;
	}
	
	@Override
	public void adduser(User user) {
		try {
			entity.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getalluser() {
		try {
			return (List<User>) entity.createQuery("select user from User user").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}

}
