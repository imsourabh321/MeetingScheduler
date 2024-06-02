package com.calendarassistant.calendar_assistant.service;

import java.util.List;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Meeting;

public interface MeetingService {
    Meeting findById(Long id) throws NotFoundException;
    Meeting save(Meeting meeting);
    void deleteById(Long id);
    List<Meeting> findAll();
}
