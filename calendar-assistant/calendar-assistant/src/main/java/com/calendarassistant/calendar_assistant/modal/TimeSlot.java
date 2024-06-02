package com.calendarassistant.calendar_assistant.modal;

import java.time.LocalDateTime;

public class TimeSlot {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    public TimeSlot() {
		super();
		// TODO Auto-generated constructor stub
	}
    
 public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
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

	@Override
	public String toString() {
		return "TimeSlot [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
    
}