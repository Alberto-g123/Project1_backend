package dev.gutierrez.handlers.complaint;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import dev.gutierrez.entities.Entities.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Complaint complaint = gson.fromJson(json, Complaint.class);
        Complaint createdComplaint = App.complaintService.createComplaint(complaint);
        String complaintJson = gson.toJson(createdComplaint);
        ctx.status(201);
        ctx.result(complaintJson);
    }
}
