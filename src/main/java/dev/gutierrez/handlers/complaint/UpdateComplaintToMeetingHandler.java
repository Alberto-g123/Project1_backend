package dev.gutierrez.handlers.complaint;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import dev.gutierrez.entities.Entities.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintToMeetingHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int meeting = Integer.parseInt(ctx.pathParam("meeting_id"));
        Gson gson = new Gson();
        Complaint complaint = App.complaintService.getComplaintById(id);
        if(complaint != App.meetingService.getAllMeeting()){
            ctx.status(304);
        }
        complaint = App.complaintService.editComplaintToMeeting(id, meeting);
        String json = gson.toJson(complaint);
        ctx.result(json);
        ctx.status(202);



    }
}
