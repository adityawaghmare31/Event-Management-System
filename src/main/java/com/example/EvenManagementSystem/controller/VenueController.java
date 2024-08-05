package com.example.EvenManagementSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvenManagementSystem.Exceptions.InvalidCredentialsException;
import com.example.EvenManagementSystem.Exceptions.ResourceNotFoundException;
import com.example.EvenManagementSystem.Exceptions.SomethingWentWrongException;
import com.example.EvenManagementSystem.entity.Venue;
import com.example.EvenManagementSystem.service.VenueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/venue")
public class VenueController {

	@Autowired
	private VenueService venueService;

	@PostMapping("/createvenue")
	public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
		Venue createdVenue = venueService.createVenue(venue);
		if (createdVenue != null) {
			return new ResponseEntity<Venue>(createdVenue, HttpStatus.CREATED);
		} else {
			throw new InvalidCredentialsException("Venue Not Created Because Of Invalid Credentials :" + createdVenue);
		}
	}

	@GetMapping(value = "/getVenueById/{id}")
	public ResponseEntity<Optional<Venue>> getEventById(@PathVariable long id) {
		Optional<Venue> eventById = venueService.getEventById(id);
		if (eventById != null) {
			return new ResponseEntity<Optional<Venue>>(eventById, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Venue Not found With Id :" + id);
		}
	}

	@PutMapping(value = "/Update-Venue/{id}")
	public ResponseEntity<String> UpdateVenue(@PathVariable long id, @RequestBody Venue venue) {
		String updateVenue = venueService.UpdateVenue(id, venue);
		if (updateVenue != null) {
			return new ResponseEntity<String>(updateVenue, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Venue Not found With Id :" + id);
		}
	}

	@DeleteMapping(value = "/Delete-Venue/{id}")
	public ResponseEntity<String> deleteVenue(@PathVariable long id) {
		venueService.deleteVenue(id);
		// if(deleteVenue!=null) {
		return ResponseEntity.ok("Venue Deleted Successfully");
		// }
		// else {
		// throw new SomethingWentWrongException("Something Went Wrong :" + id);
		// }
	}

}
