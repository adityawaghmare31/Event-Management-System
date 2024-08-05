package com.example.EvenManagementSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Organizer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long organizerId;
	private String name;
	private String contactInfo;
	
	@OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
	@JsonIgnore
	 @JsonManagedReference
	private List<Event>events;

	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organizer(long organizerId, String name, String contactInfo, List<Event> events) {
		super();
		this.organizerId = organizerId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.events = events;
	}

	public long getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(long organizerId) {
		this.organizerId = organizerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", name=" + name + ", contactInfo=" + contactInfo + ", events="
				+ events + "]";
	}
	
	
}
