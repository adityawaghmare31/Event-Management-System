package com.example.EvenManagementSystem.service;

import java.util.Optional;

import com.example.EvenManagementSystem.entity.Organizer;

public interface OrganizerService {

	Organizer createOrganizer(Organizer organizer);

	Optional<Organizer> getOrganizerById(long id);

	String updateOrganizer(long id, Organizer organizer);

	void deleteVenue(long id);

}
