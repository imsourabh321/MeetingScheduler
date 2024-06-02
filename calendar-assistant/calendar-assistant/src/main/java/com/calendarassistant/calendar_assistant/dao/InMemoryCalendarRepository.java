package com.calendarassistant.calendar_assistant.dao;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCalendarRepository implements CalendarRepository {
    private final Map<Long, Calendar> calendars = new HashMap<>();
    private static Long idCounter = 0L;

    @Override
    public Calendar findById(Long id) throws NotFoundException {
        Calendar calendar = calendars.get(id);
        if (calendar == null) {
            throw new NotFoundException("Calendar not found with id: " + id);
        }
        return calendar;
    }

    @Override
    public Calendar save(Calendar calendar) {
        if (calendar.getId() == null) {
            calendar.setId(++idCounter);
        }
        calendars.put(calendar.getId(), calendar);
        return calendar;
    }

    @Override
    public void deleteById(Long id) {
        calendars.remove(id);
    }

    @Override
    public List<Calendar> findAll() {
        return new ArrayList<>(calendars.values());
    }
}
