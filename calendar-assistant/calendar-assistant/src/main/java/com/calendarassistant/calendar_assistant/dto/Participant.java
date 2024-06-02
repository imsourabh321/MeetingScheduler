package com.calendarassistant.calendar_assistant.dto;

public class Participant {
    private Long id;
    private String name;
    private String email;
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participant(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
    
    
}
