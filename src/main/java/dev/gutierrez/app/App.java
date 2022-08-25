package dev.gutierrez.app;

import com.google.gson.Gson;
import dev.gutierrez.daos.appuser.AppUserDAOPostgres;
import dev.gutierrez.daos.complaint.ComplaintDAOPostgres;
import dev.gutierrez.daos.meeting.MeetingDAOPostgres;
import dev.gutierrez.dtos.LoginCredentials;
import dev.gutierrez.entities.Entities.AppUser;
import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.exceptions.NoUserFoundException;
import dev.gutierrez.exceptions.PasswordException;
import dev.gutierrez.handlers.appuser.LoginHandler;
import dev.gutierrez.handlers.complaint.AllComplaintHandler;
import dev.gutierrez.handlers.complaint.CreateComplaintHandler;
import dev.gutierrez.handlers.complaint.UpdateComplaintHandler;
import dev.gutierrez.handlers.meeting.AllMeetingHandler;
import dev.gutierrez.handlers.meeting.CreateMeetingHandler;
import dev.gutierrez.services.complaint.ComplaintService;
import dev.gutierrez.services.complaint.ComplaintServiceImpl;
import dev.gutierrez.services.login.LoginService;
import dev.gutierrez.services.login.LoginServiceImpl;
import dev.gutierrez.services.meeting.MeetingService;
import dev.gutierrez.services.meeting.MeetingServiceImpl;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Complaint> complaint = new ArrayList();

    public static ComplaintService complaintService = new ComplaintServiceImpl(new ComplaintDAOPostgres());
    public static MeetingService meetingService = new MeetingServiceImpl(new MeetingDAOPostgres());
    public static LoginService loginService = new LoginServiceImpl(new AppUserDAOPostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create(config->{

            config.enableCorsForAllOrigins();
        });

        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();
        AllComplaintHandler allComplaintHandler = new AllComplaintHandler();
        UpdateComplaintHandler updateComplaintHandler = new UpdateComplaintHandler();


        app.post("/complaints", createComplaintHandler);
        app.get("/complaints", allComplaintHandler);
        app.patch("/complaints/{id}/{status}", updateComplaintHandler);


        CreateMeetingHandler createMeetingHandler = new CreateMeetingHandler();
        AllMeetingHandler allMeetingHandler = new AllMeetingHandler();

        app.post("/meetings", createMeetingHandler);
        app.get("/meetings", allMeetingHandler);

        LoginHandler loginHandler = new LoginHandler();

        app.post("/login", loginHandler);

        app.exception(PasswordException.class,(exception, ctx) -> {
            ctx.status(400);
            ctx.result("password did not match");
        });
        app.exception(NoUserFoundException.class,(exception, ctx) -> {
            ctx.status(404);
            ctx.result("no User found");
        });


        app.start();
    }


}
