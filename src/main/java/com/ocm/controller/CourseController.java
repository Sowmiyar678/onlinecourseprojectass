package com.ocm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ocm.bean.Course;
import com.ocm.dao.CourseDAO;
import com.ocm.dao.CourseDAOImpl;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CourseController {

	@Autowired
	CourseDAOImpl dao;

	@PostMapping("/CreateCourse")
	public String addcourse(@RequestBody Course course) {
		String msg="";
		try {
			dao.addcourse(course);
			msg="Course Details Saved";
		}catch(Exception e) {
			msg="Course Details not saved";
		}
		return msg;
	}

	 @GetMapping("/GetCourse/{id}")
		public Course getcourse(@PathVariable("id") int id) {
			return dao.getcourse(id);
		}
//	 get();
////	 id populate
//	 @GetMapping("/GetCourseId")
//		List<Integer> fetchCourseIds() {
//			return repo.fetchCourseIds();
//		}
//	 @GetMapping("/courseAutoPop")
//		public List<Integer> doAutoPop(){
//			return repo.getIdList();
//		}
//	 
	 @GetMapping("/GetAllCourse")
		public List<Course> getallcourse() {
			return dao.getallcourse();
			}

}
