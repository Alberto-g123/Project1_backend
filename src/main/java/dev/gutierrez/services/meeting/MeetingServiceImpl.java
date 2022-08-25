package dev.gutierrez.services.meeting;

import dev.gutierrez.daos.meeting.MeetingDAO;
import dev.gutierrez.entities.Entities.Meeting;

import java.util.List;

public class MeetingServiceImpl implements MeetingService{

    private MeetingDAO meetingDAO;
    public MeetingServiceImpl(MeetingDAO meetingDAO){
        this.meetingDAO = meetingDAO;
    }
    @Override
    public Meeting createMeeting(Meeting meeting) {
        if(meeting.getAddress().length() == 0){
            throw new RuntimeException("must have an address");
        } else if(meeting.getSummary().length() == 0){
            throw new RuntimeException("please give a summary");
        } else if(meeting.getTime() == 0){
            throw new RuntimeException("please give a time");
        } else{
            Meeting savedMeeting = this.meetingDAO.createMeeting(meeting);
            return savedMeeting;
        }

    }

    @Override
    public List<Meeting> getAllMeeting() {
        return this.meetingDAO.getAllMeeting();
    }
}
