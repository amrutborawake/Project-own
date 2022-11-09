package com.stackroute.dao;



import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.model.Jobs;



@Repository 
public interface JobsDao extends JpaRepository<Jobs, Integer>{
	
	//creating custom Query for getting userjobs 
	
	@Query("select j FROM Jobs j WHERE j.username = :n")
	public List<Jobs> getJobByUsername(@Param("n") String name);
	
	//creating custom Query for deleting userjobs 
	
	@Transactional
	@Modifying
	@Query("delete FROM Jobs WHERE (username = :n AND id = :id)")
	public void deleteJobByUserNameAndId(@Param("n") String name, @Param("id") int jid);

}
