package com.example.EvenManagementSystem.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvenManagementSystem.dao.OrganizerDao;
import com.example.EvenManagementSystem.entity.Organizer;
import com.example.EvenManagementSystem.entity.Venue;
import com.example.EvenManagementSystem.service.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService {
	
	@Autowired
	private OrganizerDao organizerDao;

	@Override
	public Organizer createOrganizer(Organizer organizer) {
		return organizerDao.save(organizer);
	}

	@Override
	public Optional<Organizer> getOrganizerById(long id) {
		Optional<Organizer> OrganizerbyId = organizerDao.findById(id);
		return OrganizerbyId;
	}

	@Override
	public String updateOrganizer(long id, Organizer updatatingDetails) {
		Organizer organizerById = organizerDao.findById(id).orElseThrow();
		organizerById.setName(updatatingDetails.getName());
		organizerById.setContactInfo(updatatingDetails.getContactInfo());
		organizerDao.save(organizerById);
		return "Organizer Details Updated";
	}

	@Override
	public void deleteVenue(long id) {
		organizerDao.deleteById(id);
	}

}
