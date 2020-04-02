package com.rohan.demoapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rohan.demoapp.entity.ReportOneEntity;

@Repository
public interface ReportOneRepository extends CrudRepository<ReportOneEntity, Integer>{
	
	@Query("select count(e),info from ReportOneEntity e Group By info")
	public List<Object> getDataGroupByInfo();
}