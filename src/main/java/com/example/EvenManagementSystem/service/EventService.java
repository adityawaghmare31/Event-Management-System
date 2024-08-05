package com.example.EvenManagementSystem.service;

import java.util.List;

import com.example.EvenManagementSystem.entity.Event;
import com.example.EvenManagementSystem.entity.Organizer;

public interface EventService {

	Event createEvent(Event event);

	List<Event> getAllEvents();

	Organizer getEventById(long id);

	boolean updateEvent(long id, Event event);

	boolean deleteEvent(long id);

	List<Event> getByVenue(long venueId);

	List<Event> getByOrganizer(long organizerId);

	
}
