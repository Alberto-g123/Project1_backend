package dev.gutierrez.daos.complaint;

import dev.gutierrez.entities.Entities.Complaint;

import java.util.List;

public interface ComplaintDAO {

    Complaint createComplaint(Complaint complaint);
    Complaint getComplaintById(int id);

    List<Complaint> getAllComplaints();
    Complaint updateComplaint(Complaint complaint);

}
