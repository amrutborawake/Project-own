package com.stackroute.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.Jobs;
import com.stackroute.model.Users;
import com.stackroute.service.JobsService;



@RestController

@RequestMapping("/api/v1/")
@CrossOrigin("*")

public class JobsController {
	
	
	ResponseEntity<?> response;
	@Autowired
	JobsService service;
	boolean flag;
	
	
	//Add job to bookmark method

	@PostMapping("/addJobToBookmark")
	public ResponseEntity<?> addJobToBookmark(@RequestBody Jobs job) {
		System.out.print(job);
		flag = service.addJob(job) != null;
		
		if(flag) {
			response = new ResponseEntity<String>("Added to Bookmark",HttpStatus.CREATED);
			
		}
		else {
			response = new ResponseEntity<String>("Failure! Check the code",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	@GetMapping("/getJob/{id}")
	public ResponseEntity<?> getJob(@PathVariable("id") int jId) {

		Jobs j = null;
		
			j = service.getJob(jId);
		
		if(j!=null) {
			response = new ResponseEntity<Jobs>(j,HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;
		
	}
	
	
//	@DeleteMapping("/removeBookmarkJob/{n}")
//	public ResponseEntity<?> removeBookmarkJob(@PathVariable("n") int name,HttpSession session) {
//
//		Jobs j = null;
//		try {
//			j = service.getJob(name);
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		if(j!=null) {
//			service.deleteJob(name);
//			response = new ResponseEntity<String>("Job Has been Removed from Bookmark",HttpStatus.OK);
//		}
//		else {
//			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
//		}
//
//		return response;
//		
//	}
	
	
	//fetching job by user
	
	@GetMapping("/getJobsByUser/{n}")
	public ResponseEntity<?> getJobsByUser(@PathVariable("n") String name){
		
		List<Jobs> jobList = service.getJobByUsername(name);
		if(jobList!=null) {
			response = new ResponseEntity<List<Jobs>>(jobList,HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	
	//deleting saved job
	
	@DeleteMapping("/deleteJobByUserNameAndJobId/{n}/{id}")
	public ResponseEntity<?> deleteJobByUserNameAndJobId(@PathVariable("n") String name,@PathVariable("id") int jobid){
		
		List<Jobs> j = null;
		try {
			j = service.getJobByUsername(name);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(j!=null) {
			service.deleteJob(name, jobid);
			response = new ResponseEntity<String>("Job Has been Removed from Bookmark",HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;

}
}
