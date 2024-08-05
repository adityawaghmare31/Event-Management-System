package com.example.EvenManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EvenManagementSystem.entity.Organizer;

@Repository
public interface OrganizerDao extends JpaRepository<Organizer, Long>{

}
