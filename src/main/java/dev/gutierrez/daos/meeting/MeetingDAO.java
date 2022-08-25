package dev.gutierrez.daos.meeting;

import dev.gutierrez.entities.Entities.Meeting;

import java.util.List;

public interface MeetingDAO {

    Meeting createMeeting(Meeting meeting);
    List<Meeting> getAllMeeting();

}
