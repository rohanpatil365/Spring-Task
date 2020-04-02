package com.rohan.demoapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.demoapp.entity.CauseCode;

@Repository
public interface CauseCodeRepository  extends CrudRepository<CauseCode, Integer>{
	
	@Query("SELECT createdAt, count(createdAt) FROM CauseCode GROUP BY createdAt")
	public List<Object> getCountByDate();
	
	@Query("SELECT count(c) FROM CauseCode c")
	public int getTotalCount();
	
}
