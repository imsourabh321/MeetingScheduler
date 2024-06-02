package com.calendarassistant.calendar_assistant.service;

import com.calendarassistant.calendar_assistant.dao.CalendarRepository;
import com.calendarassistant.calendar_assistant.modal.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CalendarServiceTest {

    @Mock
    private CalendarRepository calendarRepository;

    @InjectMocks
    private CalendarServiceImpl calendarService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Calendar calendar = new Calendar();
        calendar.setId(1L);

        when(calendarRepository.findById(1L)).thenReturn(calendar);

        Calendar foundCalendar = calendarService.findById(1L);

        assertNotNull(foundCalendar);
        assertEquals(1L, foundCalendar.getId());
        verify(calendarRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Calendar calendar = new Calendar();
        calendar.setId(1L);

        when(calendarRepository.save(calendar)).thenReturn(calendar);

        Calendar savedCalendar = calendarService.save(calendar);

        assertNotNull(savedCalendar);
        assertEquals(1L, savedCalendar.getId());
        verify(calendarRepository, times(1)).save(calendar);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(calendarRepository).deleteById(1L);

        calendarService.deleteById(1L);

        verify(calendarRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindAll() {
        List<Calendar> calendars = new ArrayList<>();
        calendars.add(new Calendar());

        when(calendarRepository.findAll()).thenReturn(calendars);

        List<Calendar> foundCalendars = calendarService.findAll();

        assertNotNull(foundCalendars);
        assertEquals(1, foundCalendars.size());
        verify(calendarRepository, times(1)).findAll();
    }
}


