package com.DSSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DSSystem.entity.Actor;
import com.DSSystem.repository.ActorRepository;

//"http://localhost:4200/api/v1/actors"
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ActorControllerJpaRepo {
	@Autowired
	private ActorRepository actorRepository;
	
	@GetMapping("/actors")
	public List<Actor> getActorList() {
		List<Actor> actorList = actorRepository.findAll();
		return actorList;
	}
	
	@GetMapping("/actors/{id}")
	public Actor getActorById(@PathVariable(value="id") Integer id) {
		Actor existingActor = actorRepository.findById(id).get();
		return existingActor;
	}
	
	@GetMapping("/actors/{firstName}/{lastName}")
	public List<Actor> getActorByName(@PathVariable(value="firstName") String firstName, @PathVariable(value="lastName")String lastName) {
		List<Actor> existingActor = actorRepository.findByFirstNameAndLastName(firstName,lastName);
		return existingActor;
	}

	@PostMapping("/actors")
	public Actor createActor(@RequestBody Actor actor) {

		Actor savedActor = actorRepository.save(actor);
		return savedActor;
	}
	
	@PutMapping("/actors/{id}")
	public Actor updateActor(@PathVariable(value="id") Integer id, @RequestBody Actor actor) {
		// fetch the actor
		Actor existingActor = actorRepository.findById(id).get();
		existingActor.setActorId(actor.getActorId());
		existingActor.setFirstName(actor.getFirstName());
		existingActor.setLastName(actor.getLastName());
		existingActor.setAbout(actor.getAbout());
		existingActor.setGender(actor.getGender());
		existingActor.setAge(actor.getAge());
		existingActor.setActorUrl(actor.getActorUrl());
		
		Actor savedActor = actorRepository.save(actor);
		return savedActor;
	}
	@DeleteMapping("/actors/{id}")
	public Actor deleteActorById(@PathVariable(value="id") Integer id) {
		Actor existingActor = actorRepository.findById(id).get();
	    actorRepository.delete(existingActor);
		return existingActor;
	}
	
//	@DeleteMapping("/actors/{id}")
//	public Map<String,Boolean> deleteActorById(@PathVariable(value="id") Integer id) {
//		Actor existingActor = actorRepository.findById(id).get();
//	    actorRepository.delete(existingActor);
//	    Map<String, Boolean> response = new HashMap<>();
//	    response.put("deleted", Boolean.TRUE);
//		return response;
//	}
}
