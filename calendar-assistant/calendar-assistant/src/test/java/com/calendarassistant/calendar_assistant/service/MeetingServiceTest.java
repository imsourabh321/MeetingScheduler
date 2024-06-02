package com.calendarassistant.calendar_assistant.service;


import com.calendarassistant.calendar_assistant.dao.MeetingRepository;
import com.calendarassistant.calendar_assistant.exception.ConflictException;
import com.calendarassistant.calendar_assistant.modal.Meeting;
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


public class MeetingServiceTest {

    @Mock
    private MeetingRepository meetingRepository;

    @InjectMocks
    private MeetingServiceImpl meetingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Meeting meeting = new Meeting();
        meeting.setId(1L);

        when(meetingRepository.findById(1L)).thenReturn(meeting);

        Meeting foundMeeting = meetingService.findById(1L);

        assertNotNull(foundMeeting);
        assertEquals(1L, foundMeeting.getId());
        verify(meetingRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Meeting meeting = new Meeting();
        meeting.setId(1L);

        when(meetingRepository.save(meeting)).thenReturn(meeting);

        Meeting savedMeeting = meetingService.save(meeting);

        assertNotNull(savedMeeting);
        assertEquals(1L, savedMeeting.getId());
        verify(meetingRepository, times(1)).save(meeting);
    }

    @Test
    public void testSaveWithConflict() {
        Meeting meeting = new Meeting();
        meeting.setId(1L);

        doThrow(new ConflictException("Conflict")).when(meetingRepository).save(meeting);

        try {
            meetingService.save(meeting);
        } catch (ConflictException e) {
            assertEquals("Conflict", e.getMessage());
        }

        verify(meetingRepository, times(1)).save(meeting);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(meetingRepository).deleteById(1L);

        meetingService.deleteById(1L);

        verify(meetingRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindAll() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting());

        when(meetingRepository.findAll()).thenReturn(meetings);

        List<Meeting> foundMeetings = meetingService.findAll();

        assertNotNull(foundMeetings);
        assertEquals(1, foundMeetings.size());
        verify(meetingRepository, times(1)).findAll();
    }
}
