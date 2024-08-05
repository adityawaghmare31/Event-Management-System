package com.example.EvenManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EvenManagementSystem.entity.Venue;

@Repository
public interface VenueDao extends JpaRepository<Venue, Long> {


}
