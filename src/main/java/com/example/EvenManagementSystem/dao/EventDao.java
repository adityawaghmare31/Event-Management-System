package com.example.EvenManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EvenManagementSystem.entity.Event;

@Repository
public interface EventDao extends JpaRepository<Event, Long>{

	List<Event> findByVenue_VenueId(Long venueId);
	//List<Event> findByVenueId(long venueId);

	List<Event> findByOrganizer_OrganizerId(long organizerId);

}
