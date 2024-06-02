package com.calendarassistant.calendar_assistant.modal;

import java.util.List;

public class Calendar {
    private Long id;
    private Employee owner;
    private List<Meeting> meetings;
    
    public Calendar() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Calendar(Long id, Employee owner, List<Meeting> meetings) {
		super();
		this.id = id;
		this.owner = owner;
		this.meetings = meetings;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	public List<Meeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", owner=" + owner + ", meetings=" + meetings + "]";
	}
	
	
    
}
