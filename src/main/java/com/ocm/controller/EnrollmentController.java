package com.ocm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ocm.bean.Enrollment;
import com.ocm.dao.EnrollmentDAO;
import com.ocm.dao.EnrollmentDAOImpl;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EnrollmentController {
	
	@Autowired
	EnrollmentDAOImpl dao;
	
	@PostMapping("/CreateEnroll")
	public String addenroll(@RequestBody Enrollment enroll) {
		String msg="";
		try {
			dao.addenroll(enroll);
			msg="Enroll Object Saved";
		}catch(Exception e) {	
			msg="Enroll Object Not Saved";
		}
		return msg;
	}
	
	
	 
	 @GetMapping("/GetAllEnroll")
		public List<Enrollment> getallenroll() {
			return dao.getallenroll();
			}

}
