package com.calendarassistant.calendar_assistant.dao;

import java.util.List;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Meeting;

public interface MeetingRepository {
    Meeting findById(Long id) throws NotFoundException;
    Meeting save(Meeting meeting);
    void deleteById(Long id);
	List<Meeting> findAll();
}
