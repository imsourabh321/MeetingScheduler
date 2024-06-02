package com.calendarassistant.calendar_assistant.modal;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private Long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Employee> participants;
	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meeting(Long id, String title, LocalDateTime startTime, LocalDateTime endTime, List<Employee> participants) {
		super();
		this.id = id;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participants = participants;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public List<Employee> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Employee> participants) {
		this.participants = participants;
	}
	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", participants=" + participants + "]";
	}
    
    
}