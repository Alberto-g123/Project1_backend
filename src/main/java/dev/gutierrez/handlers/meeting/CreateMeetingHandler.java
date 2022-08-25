package dev.gutierrez.handlers.meeting;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import dev.gutierrez.entities.Entities.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateMeetingHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Meeting meeting = gson.fromJson(json, Meeting.class);
        Meeting createdMeeting = App.meetingService.createMeeting(meeting);
        String meetingJson = gson.toJson(createdMeeting);
        ctx.status(201);
        ctx.result(meetingJson);
    }
}
