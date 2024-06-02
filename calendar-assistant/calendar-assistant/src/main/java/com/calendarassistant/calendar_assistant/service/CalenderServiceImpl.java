package com.calendarassistant.calendar_assistant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calendarassistant.calendar_assistant.dao.CalendarRepository;
import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Calendar;

@Service
class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;

    public CalendarServiceImpl(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public Calendar findById(Long id) throws NotFoundException {
        return calendarRepository.findById(id);
    }

    @Override
    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public void deleteById(Long id) {
        calendarRepository.deleteById(id);
    }

    @Override
    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }
}