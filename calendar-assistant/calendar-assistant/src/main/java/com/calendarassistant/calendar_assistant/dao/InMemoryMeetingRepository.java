package com.calendarassistant.calendar_assistant.dao;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Meeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMeetingRepository implements MeetingRepository {
    private final Map<Long, Meeting> meetings = new HashMap<>();
    private static Long idCounter = 0L;

    @Override
    public Meeting findById(Long id) throws NotFoundException {
        Meeting meeting = meetings.get(id);
        if (meeting == null) {
            throw new NotFoundException("Meeting not found with id: " + id);
        }
        return meeting;
    }

    @Override
    public Meeting save(Meeting meeting) {
        if (meeting.getId() == null) {
            meeting.setId(++idCounter);
        }
        meetings.put(meeting.getId(), meeting);
        return meeting;
    }

    @Override
    public void deleteById(Long id) {
        meetings.remove(id);
    }

    @Override
    public List<Meeting> findAll() {
        return new ArrayList<>(meetings.values());
    }
}
