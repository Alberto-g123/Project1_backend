package dev.gutierrez.mockbasics;

import dev.gutierrez.daos.appuser.AppUserDAO;
import dev.gutierrez.daos.complaint.ComplaintDAO;
import dev.gutierrez.daos.meeting.MeetingDAO;
import dev.gutierrez.entities.Entities.AppUser;
import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.entities.Entities.Meeting;
import dev.gutierrez.entities.Enum.Offense;
import dev.gutierrez.entities.Enum.Status;
import dev.gutierrez.services.complaint.ComplaintService;
import dev.gutierrez.services.complaint.ComplaintServiceImpl;
import dev.gutierrez.services.login.LoginService;
import dev.gutierrez.services.login.LoginServiceImpl;
import dev.gutierrez.services.meeting.MeetingService;
import dev.gutierrez.services.meeting.MeetingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockExampleTests {


    @Test
    void register_complaint_must_have_description(){
        ComplaintDAO complaintDAO = Mockito.mock(ComplaintDAO.class);
        Complaint complaint = new Complaint(0, Offense.CRIME, "", Status.REVIEWED,0);
        Mockito.when(complaintDAO.createComplaint(complaint)).thenReturn(complaint);
        ComplaintService complaintService = new ComplaintServiceImpl(complaintDAO);

        Assertions.assertThrows(RuntimeException.class, ()->{
           complaintService.createComplaint(complaint);
        });
    }

    @Test
    void get_all_complaints(){
        ComplaintDAO complaintDAO = Mockito.mock(ComplaintDAO.class);
        List<Complaint> fakeComplaints = new ArrayList();
        fakeComplaints.add(new Complaint(0, Offense.CRIME, "joker stole my puppy", Status.REVIEWED,0));
        fakeComplaints.add(new Complaint(0, Offense.CRIME, "Harley took my cake", Status.REVIEWED,0));
        fakeComplaints.add(new Complaint(0, Offense.CRIME, "batman took the handicap parking spot", Status.REVIEWED,0));
        Mockito.when(complaintDAO.getAllComplaints()).thenReturn(fakeComplaints);
        ComplaintService complaintService = new ComplaintServiceImpl(complaintDAO);
        List<Complaint> allComplaints = complaintService.allComplaints();
        Assertions.assertEquals(3,allComplaints.size());
    }

    @Test
    void create_meeting(){
        MeetingDAO meetingDAO = Mockito.mock(MeetingDAO.class);
        Meeting fakeMeeting = new Meeting(0,"room 201", 0,"discuss about joker");
        Mockito.when(meetingDAO.createMeeting(fakeMeeting)).thenReturn(fakeMeeting);
        MeetingService meetingService = new MeetingServiceImpl(meetingDAO);

        Assertions.assertThrows(RuntimeException.class, ()->{
            meetingService.createMeeting(fakeMeeting);
        });
    }

    @Test
    void get_all_meetings(){
        MeetingDAO meetingDAO = Mockito.mock(MeetingDAO.class);
        List<Meeting> fakeMeetings = new ArrayList();
        fakeMeetings.add(new Meeting(0,"room 201", 0,"discuss about joker"));
        fakeMeetings.add(new Meeting(0,"room 201", 0,"discuss about joker"));
        fakeMeetings.add(new Meeting(0,"room 201", 0,"discuss about joker"));
        Mockito.when(meetingDAO.getAllMeeting()).thenReturn(fakeMeetings);
        MeetingService meetingService = new MeetingServiceImpl(meetingDAO);
        List<Meeting> allMeetings = meetingService.getAllMeeting();
        Assertions.assertEquals(3, allMeetings.size());
    }


    @Test
    void validate_user(){
        AppUserDAO appUserDAO = Mockito.mock(AppUserDAO.class);
        AppUser fakeUser = new AppUser(0,"Alberto","Gutierrez","albertog","password","Council");
        Mockito.when(appUserDAO.getUserByUserName("Alberto")).thenReturn(fakeUser);
        System.out.println(fakeUser);
        LoginService loginService = new LoginServiceImpl(appUserDAO);
        Assertions.assertEquals("password", fakeUser.getPassword());
    }


}
