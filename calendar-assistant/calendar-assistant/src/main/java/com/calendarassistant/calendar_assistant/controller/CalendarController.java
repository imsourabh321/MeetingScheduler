package com.calendarassistant.calendar_assistant.controller;


import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Calendar;
import com.calendarassistant.calendar_assistant.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendar> getCalendarById(@PathVariable Long id) {
        try {
            Calendar calendar = calendarService.findById(id);
            return ResponseEntity.ok(calendar);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Calendar> createCalendar(@RequestBody Calendar calendar) {
        Calendar savedCalendar = calendarService.save(calendar);
        return ResponseEntity.ok(savedCalendar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long id) {
        try {
            calendarService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Calendar>> getAllCalendars() {
        List<Calendar> calendars = calendarService.findAll();
        return ResponseEntity.ok(calendars);
    }
}

