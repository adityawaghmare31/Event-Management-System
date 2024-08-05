package com.example.EvenManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvenManagementSystem.Exceptions.InvalidCredentialsException;
import com.example.EvenManagementSystem.Exceptions.ResourceNotFoundException;
import com.example.EvenManagementSystem.entity.Event;
import com.example.EvenManagementSystem.entity.Organizer;
import com.example.EvenManagementSystem.service.EventService;
import com.example.EvenManagementSystem.service.OrganizerService;
import com.example.EvenManagementSystem.service.VenueService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/events")
public class EventController {

	@Autowired
	private EventService eventService;
	

	@PostMapping("/createEvent")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		Event createdEvent = eventService.createEvent(event);
		if (createdEvent != null) {
			return new ResponseEntity<Event>(createdEvent, HttpStatus.CREATED);
		} else {
			throw new InvalidCredentialsException("Event Not Created Because Of Invalid Credentials :" + event);
		}
	}

	@GetMapping("/Get-All-Events")
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();

	}

	@GetMapping("/get-event-by-id/{id}")
	public ResponseEntity<Organizer> getEventById(@PathVariable long id) {
		Organizer eventById = eventService.getEventById(id);
		if (eventById != null) {
			return new ResponseEntity<Organizer>(eventById, HttpStatus.ACCEPTED);
		} else {
			throw new ResourceNotFoundException("Events not available with Id:" + id);
		}
	}

	@PutMapping("update-Event/{id}")
	public ResponseEntity<String> updateEvent(@PathVariable long id, @RequestBody Event event) {
		boolean updateEvent = eventService.updateEvent(id, event);
		if (updateEvent) {
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Updated", HttpStatus.OK);
		}
	}

	@DeleteMapping("Delete-Event/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable long id) {
		boolean deleteEvent = eventService.deleteEvent(id);
		if (deleteEvent) {
			return new ResponseEntity<String>("Event Deleted Successfull", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Deleting Event Failed", HttpStatus.OK);
		}
	}

	@GetMapping("get-by-venue/venue/{venueId}")
	public ResponseEntity<List<Event>> getByVenue(@PathVariable long venueId) {
		List<Event> byVenue = eventService.getByVenue(venueId);
		if (byVenue != null) {
			return new ResponseEntity<List<Event>>(byVenue, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Events not available with venue Id:" + venueId);
		}
	}
	
	@GetMapping("get-by-organizer/{organizerId}")
	public ResponseEntity<List<Event>> getByOrganizer(@PathVariable long organizerId) {
		 List<Event> byOrganizer = eventService.getByOrganizer(organizerId);
		 if(byOrganizer != null) {
			return new ResponseEntity<List<Event>>(byOrganizer, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Events not available with venue Id:" + byOrganizer);
		}
	}
}
