package dev.gutierrez.daotests;

import com.sun.jdi.event.MethodEntryEvent;
import dev.gutierrez.daos.meeting.MeetingDAO;
import dev.gutierrez.daos.meeting.MeetingDAOPostgres;
import dev.gutierrez.entities.Entities.Meeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.metal.MetalInternalFrameTitlePane;
import java.util.List;

public class MeetingTest {

    MeetingDAO meetingDAO = new MeetingDAOPostgres();

    @Test
    void create_meeting_test(){
        Meeting meeting = new Meeting(0,"No Mans Land", 1661200688,"Discussion for who pays for all the damages the batman does");
        Meeting savedMeeting = meetingDAO.createMeeting(meeting);
        Assertions.assertNotEquals(0, savedMeeting.getMeeting_id());
        System.out.println(meeting);
    }

    @Test
    void get_all_meetings_test(){
        List<Meeting> meetingList = meetingDAO.getAllMeeting();
        Assertions.assertNotEquals(0, meetingList.size());
        System.out.println(meetingList);
    }

}
