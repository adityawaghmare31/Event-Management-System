package com.example.EvenManagementSystem.service;

import java.util.Optional;

import com.example.EvenManagementSystem.entity.Venue;

public interface VenueService {

	Venue createVenue(Venue venue);

	Optional<Venue> getEventById(long id);

	String UpdateVenue(long id, Venue venue);

	void deleteVenue(long id);

}
