package com.calendarassistant.calendar_assistant.controller;

import com.calendarassistant.calendar_assistant.exception.ConflictException;
import com.calendarassistant.calendar_assistant.modal.Meeting;
import com.calendarassistant.calendar_assistant.service.MeetingService;
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

public class MeetingControllerTest {

    @Mock
    private MeetingService meetingService;

    @InjectMocks
    private MeetingController meetingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMeetingById() {
        Meeting meeting = new Meeting();
        meeting.setId(1L);

        when(meetingService.findById(1L)).thenReturn(meeting);

        ResponseEntity<Meeting> response = meetingController.getMeetingById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(meetingService, times(1)).findById(1L);
    }

    @Test
    public void testCreateMeeting() {
        Meeting meeting = new Meeting();
        meeting.setId(1L);

        when(meetingService.save(meeting)).thenReturn(meeting);

        ResponseEntity<Meeting> response = meetingController.createMeeting(meeting);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(meetingService, times(1)).save(meeting);
    }

    @Test
    public void testCreateMeetingConflict() {
        Meeting meeting = new Meeting();
        meeting.setId(1L);

        when(meetingService.save(meeting)).thenThrow(new ConflictException("Conflict"));

        ResponseEntity<Meeting> response = meetingController.createMeeting(meeting);

        assertEquals(409, response.getStatusCodeValue());
        verify(meetingService, times(1)).save(meeting);
    }

    @Test
    public void testDeleteMeeting() {
        doNothing().when(meetingService).deleteById(1L);

        ResponseEntity<Void> response = meetingController.deleteMeeting(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(meetingService, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAllMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting());

        when(meetingService.findAll()).thenReturn(meetings);

        ResponseEntity<List<Meeting>> response = meetingController.getAllMeetings();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(meetingService, times(1)).findAll();
    }
}
