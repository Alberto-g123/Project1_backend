package dev.gutierrez.handlers.complaint;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.entities.Enum.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        int id = Integer.parseInt(ctx.pathParam("id"));
        String status = ctx.pathParam("status");
        Complaint complaint = App.complaintService.getComplaintById(id);
        if (complaint == null) {
            return;
        }
        status.toLowerCase();
        switch (status) {
            case "high":
                complaint = App.complaintService.editComplaint(id, Status.HIGH_PRIORITY);
                break;
            case "low":
                complaint = App.complaintService.editComplaint(id, Status.LOW_PRIORITY);
                break;
            case "ignore":
                complaint = App.complaintService.editComplaint(id, Status.IGNORED);
                break;
            case "addressed":
                complaint = App.complaintService.editComplaint(id, Status.ADDRESSED);
                break;
            default:
                ctx.status(304);
                return;
        }
        Gson gson = new Gson();
        ctx.result(gson.toJson(complaint));
        ctx.status(202);
    }
}
