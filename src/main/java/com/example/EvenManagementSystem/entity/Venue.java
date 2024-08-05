package com.example.EvenManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long venueId;
	private String name;
	private String location;
	private int capacity;
	
	@OneToOne(mappedBy = "venue")
	private Event event;

	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venue(long venueId, String name, String location, int capacity, Event event) {
		super();
		this.venueId = venueId;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.event = event;
	}

	public long getVenueId() {
		return venueId;
	}

	public void setVenueId(long venueId) {
		this.venueId = venueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", name=" + name + ", location=" + location + ", capacity=" + capacity
				+ ", event=" + event + "]";
	}
	
	
}
