package dev.gutierrez.entities.Entities;

import dev.gutierrez.entities.Enum.Offense;
import dev.gutierrez.entities.Enum.Status;

public class Complaint {
    private int complaint_id;
    private Offense offense;
    private String description;
    private Status status;
    private int meeting_id;

    public Complaint() {
    }

    public Complaint(int complaint_id, Offense offense, String description, Status status, int meeting_id) {
        this.complaint_id = complaint_id;
        this.offense = offense;
        this.description = description;
        this.status = status;
        this.meeting_id = meeting_id;
    }

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public Offense getOffense() {
        return offense;
    }

    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaint_id=" + complaint_id +
                ", offense=" + offense +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", meeting_id=" + meeting_id +
                '}';
    }
}
