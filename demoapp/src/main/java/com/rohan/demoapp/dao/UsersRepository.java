package com.rohan.demoapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohan.demoapp.entity.UserEntity;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Integer>{

}
