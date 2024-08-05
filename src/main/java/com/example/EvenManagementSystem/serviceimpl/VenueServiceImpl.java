package com.example.EvenManagementSystem.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvenManagementSystem.dao.VenueDao;
import com.example.EvenManagementSystem.entity.Venue;
import com.example.EvenManagementSystem.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDao venueDao;

	@Override
	public Venue createVenue(Venue venue) {
		return venueDao.save(venue);
	}

	@Override
	public Optional<Venue> getEventById(long id) {
		Optional<Venue> VenuebyId = venueDao.findById(id);
		return VenuebyId;
	}

	@Override
	public String UpdateVenue(long id, Venue updatatingDetails) {
		Venue VenueById = venueDao.findById(id).orElseThrow();
		VenueById.setName(updatatingDetails.getName());
		VenueById.setLocation(updatatingDetails.getLocation());
		VenueById.setCapacity(updatatingDetails.getCapacity());
		venueDao.save(VenueById);
		return "Venue Details Updated";

	}

	@Override
	public void deleteVenue(long id) {
		 venueDao.deleteById(id);
	}

}
