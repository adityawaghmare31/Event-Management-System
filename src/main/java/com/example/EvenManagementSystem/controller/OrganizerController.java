package com.example.EvenManagementSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvenManagementSystem.Exceptions.InvalidCredentialsException;
import com.example.EvenManagementSystem.Exceptions.ResourceNotFoundException;
import com.example.EvenManagementSystem.entity.Organizer;
import com.example.EvenManagementSystem.entity.Venue;
import com.example.EvenManagementSystem.service.OrganizerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/organizer")
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;
	
	@PostMapping("/createorganizer")
	public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
		Organizer createdOrganizer = organizerService.createOrganizer(organizer);
		if(createdOrganizer!=null) {
			return new ResponseEntity<Organizer>(createdOrganizer,HttpStatus.CREATED);
		}
		else {
			throw new InvalidCredentialsException("Event Not Created Because Of Invalid Credentials :" + organizer);
		}
		}
	
	@GetMapping(value="/get-Organizer-By-Id/{id}")
	public ResponseEntity<Optional<Organizer>> getOrganizerById(@PathVariable long id) {
		 Optional<Organizer> organizerById = organizerService.getOrganizerById(id);
		if(organizerById!=null) {
			return new ResponseEntity<Optional<Organizer>>(organizerById,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Organizer Not found With Id :" + id);
		}
	}
	
	@PutMapping(value="/Update-Organizer/{id}")
	public ResponseEntity<String> updateOrganizer(@PathVariable long id, @RequestBody Organizer organizer) {
		 String updateOrganizer = organizerService.updateOrganizer(id,organizer);
		if(updateOrganizer!=null) {
			return new ResponseEntity<String>(updateOrganizer,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Organizer Not found With Id :" + id);
		}
	}
	
	
	@DeleteMapping(value="/Delete-Organizer/{id}")
	public ResponseEntity<String> deleteVenue(@PathVariable long id) {
		 organizerService.deleteVenue(id);
		//if(deleteVenue!=null) {
			return ResponseEntity.ok("Organizer deleted Successfully");
		//}
	//	else {
		//	throw new SomethingWentWrongException("Something Went Wrong :" + id);
		//}
	}
	

	
}
