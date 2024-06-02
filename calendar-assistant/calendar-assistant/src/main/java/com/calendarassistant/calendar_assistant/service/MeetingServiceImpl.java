package com.calendarassistant.calendar_assistant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calendarassistant.calendar_assistant.dao.MeetingRepository;
import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Meeting;

@Service
class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Meeting findById(Long id) throws NotFoundException {
        return meetingRepository.findById(id);
    }

    @Override
    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public void deleteById(Long id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }
}