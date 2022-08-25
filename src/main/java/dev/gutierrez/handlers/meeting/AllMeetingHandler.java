package dev.gutierrez.handlers.meeting;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class AllMeetingHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(App.meetingService.getAllMeeting());
        ctx.result(json);
    }
}
