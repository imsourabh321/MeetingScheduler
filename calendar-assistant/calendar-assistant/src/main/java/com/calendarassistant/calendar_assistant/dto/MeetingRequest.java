package com.calendarassistant.calendar_assistant.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MeetingRequest {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Long> participantIds;  // List of Employee IDs who will participate in the meeting
    
    public MeetingRequest() {}
	
    public MeetingRequest(String title, LocalDateTime startTime, LocalDateTime endTime, List<Long> participantIds) {
		super();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participantIds = participantIds;
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

	public List<Long> getParticipantIds() {
		return participantIds;
	}

	public void setParticipantIds(List<Long> participantIds) {
		this.participantIds = participantIds;
	}

	@Override
	public String toString() {
		return "MeetingRequest [title=" + title + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", participantIds=" + participantIds + "]";
	}
    
    
    
}

