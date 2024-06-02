package com.calendarassistant.calendar_assistant.dao;

import java.util.List;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Calendar;

public interface CalendarRepository {
    Calendar findById(Long id) throws NotFoundException;
    Calendar save(Calendar calendar);
    void deleteById(Long id);
	List<Calendar> findAll();
}
