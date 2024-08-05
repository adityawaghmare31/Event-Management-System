package com.example.EvenManagementSystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvenManagementSystem.dao.EventDao;
import com.example.EvenManagementSystem.dao.OrganizerDao;
import com.example.EvenManagementSystem.dao.VenueDao;
import com.example.EvenManagementSystem.entity.Event;
import com.example.EvenManagementSystem.entity.Organizer;
import com.example.EvenManagementSystem.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private OrganizerDao organizerDao;
	
	@Autowired
	private VenueDao venueDao;

	@Override
	public Event createEvent(Event event) {
		return eventDao.save(event);
	//	return "Event Created Successfull";
		
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> all = eventDao.findAll();
		return all;
	}

	@Override
	public Organizer getEventById(long id) {
		Event byId = eventDao.findById(id).orElseThrow();
		Organizer organizer=null;
		if(byId!=null) {
			 organizer = byId.getOrganizer();
		}
		return organizer;
		
	}

	@Override
	public boolean updateEvent(long id, Event updatingEvents) {
		 Event event = eventDao.findById(id).orElseThrow();
		event.setEventName(updatingEvents.getEventName());
		event.setDescription(updatingEvents.getDescription());
		event.setEventDate(updatingEvents.getEventDate());
		event.setVenue(updatingEvents.getVenue());
		event.setOrganizer(updatingEvents.getOrganizer());
		eventDao.save(event);
		return true;
	}

	@Override
	public boolean deleteEvent(long id) {
		eventDao.deleteById(id);
		return true;
		
	}

	@Override
	public List<Event> getByVenue(long venueId) {
		 List<Event> byVenue_VenueId = eventDao.findByVenue_VenueId(venueId);
		 return byVenue_VenueId;
	}

	@Override
	public List<Event> getByOrganizer(long organizerId) {
		return eventDao.findByOrganizer_OrganizerId(organizerId);
		
	}
	
}
