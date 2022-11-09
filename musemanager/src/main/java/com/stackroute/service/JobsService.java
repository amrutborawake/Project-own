package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dao.JobsDao;
import com.stackroute.model.Jobs;
import com.stackroute.model.Users;





@Service
public class JobsService {
	
	
	
	@Autowired
	JobsDao dao;
	
	 //adding job to bookmark 
	
	
		public Jobs addJob(Jobs job){
			Jobs j = dao.save(job);
			if(j!=null)
				return j;
			return null;
			
			
		}
		
		//get the job by id
		
		public Jobs getJob(int id) {
			Optional<Jobs> j=dao.findById(id);
			if(j.isPresent()) {
				return j.get();
			}else {
			return null;
			}
		}
		
		//deleting job from bookmark 
		public void deleteJob(String name,int id) {

			dao.deleteJobByUserNameAndId(name,id);
			
		
			
		
		}
		
		//get all jobs
		
		public List<Jobs> getAllJobs() {

			return dao.findAll();
		}
		
		
		//get job username
		public List<Jobs> getJobByUsername(String name){
			return dao.getJobByUsername(name);
		}
		
	

}
