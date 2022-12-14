package dev.gutierrez.handlers.complaint;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class AllComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(App.complaintService.allComplaints());
        ctx.result(json);
    }
}
