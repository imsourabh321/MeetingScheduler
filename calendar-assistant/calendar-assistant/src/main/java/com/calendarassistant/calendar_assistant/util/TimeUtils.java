package com.calendarassistant.calendar_assistant.util;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.calendarassistant.calendar_assistant.modal.TimeSlot;

public class TimeUtils {

    /**
     * Check if two time slots overlap.
     *
     * @param slot1 First time slot
     * @param slot2 Second time slot
     * @return true if the time slots overlap, false otherwise
     */
    public static boolean isOverlapping(TimeSlot slot1, TimeSlot slot2) {
        return slot1.getStartTime().isBefore(slot2.getEndTime()) && slot1.getEndTime().isAfter(slot2.getStartTime());
    }

    /**
     * Find free time slots of a given duration between a list of meetings.
     *
     * @param meetings List of existing meetings
     * @param duration Duration of the required free slot in minutes
     * @return List of free time slots
     */
    public static List<TimeSlot> findFreeTimeSlots(List<TimeSlot> meetings, int duration) {
        List<TimeSlot> freeSlots = new ArrayList<>();
        LocalDateTime startOfDay = LocalDateTime.of(meetings.get(0).getStartTime().toLocalDate(), LocalDateTime.MIN.toLocalTime());
        LocalDateTime endOfDay = LocalDateTime.of(meetings.get(0).getStartTime().toLocalDate(), LocalDateTime.MAX.toLocalTime());

        // Sort meetings by start time
        meetings.sort((m1, m2) -> m1.getStartTime().compareTo(m2.getStartTime()));

        // Check time between start of day and first meeting
        if (ChronoUnit.MINUTES.between(startOfDay, meetings.get(0).getStartTime()) >= duration) {
            freeSlots.add(new TimeSlot(startOfDay, meetings.get(0).getStartTime()));
        }

        // Check time between meetings
        for (int i = 0; i < meetings.size() - 1; i++) {
            LocalDateTime endTimeCurrent = meetings.get(i).getEndTime();
            LocalDateTime startTimeNext = meetings.get(i + 1).getStartTime();
            if (ChronoUnit.MINUTES.between(endTimeCurrent, startTimeNext) >= duration) {
                freeSlots.add(new TimeSlot(endTimeCurrent, startTimeNext));
            }
        }

        // Check time between last meeting and end of day
        if (ChronoUnit.MINUTES.between(meetings.get(meetings.size() - 1).getEndTime(), endOfDay) >= duration) {
            freeSlots.add(new TimeSlot(meetings.get(meetings.size() - 1).getEndTime(), endOfDay));
        }

        return freeSlots;
    }
}
