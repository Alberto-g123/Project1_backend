package dev.gutierrez.services.meeting;

import dev.gutierrez.entities.Entities.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting createMeeting(Meeting meeting);
    List<Meeting> getAllMeeting();
}
