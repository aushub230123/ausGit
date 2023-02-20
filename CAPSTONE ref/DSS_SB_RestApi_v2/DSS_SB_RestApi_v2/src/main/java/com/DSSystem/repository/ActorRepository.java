package com.DSSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DSSystem.entity.Actor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer>{
	List<Actor> findByFirstNameAndLastName(String firstName,String LastName);
	

}
