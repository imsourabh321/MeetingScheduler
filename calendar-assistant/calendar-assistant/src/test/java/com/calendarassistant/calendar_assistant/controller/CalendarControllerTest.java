package com.calendarassistant.calendar_assistant.controller;


import com.calendarassistant.calendar_assistant.modal.Calendar;
import com.calendarassistant.calendar_assistant.service.CalendarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CalendarControllerTest {

    @Mock
    private CalendarService calendarService;

    @InjectMocks
    private CalendarController calendarController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCalendarById() {
        Calendar calendar = new Calendar();
        calendar.setId(1L);

        when(calendarService.findById(1L)).thenReturn(calendar);

        ResponseEntity<Calendar> response = calendarController.getCalendarById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(calendarService, times(1)).findById(1L);
    }

    @Test
    public void testCreateCalendar() {
        Calendar calendar = new Calendar();
        calendar.setId(1L);

        when(calendarService.save(calendar)).thenReturn(calendar);

        ResponseEntity<Calendar> response = calendarController.createCalendar(calendar);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(calendarService, times(1)).save(calendar);
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testDeleteCalendar() {
        doNothing().when(calendarService).deleteById(1L);

        ResponseEntity<Void> response = calendarController.deleteCalendar(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(calendarService, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAllCalendars() {
        List<Calendar> calendars = new ArrayList<>();
        calendars.add(new Calendar());

        when(calendarService.findAll()).thenReturn(calendars);

        ResponseEntity<List<Calendar>> response = calendarController.getAllCalendars();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(calendarService, times(1)).findAll();
    }
}

