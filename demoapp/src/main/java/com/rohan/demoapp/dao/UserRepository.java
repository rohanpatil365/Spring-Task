package com.rohan.demoapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.demoapp.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {
    
    List<User> findByName(String name);
    
}
