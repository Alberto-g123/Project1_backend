package dev.gutierrez.services.complaint;

import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.entities.Enum.Status;

import java.util.List;

public interface ComplaintService {
    Complaint createComplaint(Complaint complaint);
    Complaint getComplaintById(int id);

    List<Complaint> allComplaints();


    Complaint editComplaint(int id, Status status);


}
