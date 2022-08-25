package dev.gutierrez.services.complaint;

import dev.gutierrez.daos.complaint.ComplaintDAO;
import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.entities.Enum.Status;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService{

    private ComplaintDAO complaintDAO;

    public ComplaintServiceImpl(ComplaintDAO complaintDAO){
        this.complaintDAO = complaintDAO;
    }
    @Override
    public Complaint createComplaint(Complaint complaint) {
        if(complaint.getOffense() == null){
            throw new RuntimeException("must have a Offense!");
        } else if (complaint.getDescription().length() == 0){
            throw new RuntimeException("please give a description");
        } else {
            Complaint savedComplaint = this.complaintDAO.createComplaint(complaint);
            return savedComplaint;
        }
    }

    @Override
    public Complaint getComplaintById(int id) {
        return this.complaintDAO.getComplaintById(id);
    }

    @Override
    public List<Complaint> allComplaints() {
        return this.complaintDAO.getAllComplaints();
    }

    @Override
    public Complaint editComplaint(int id, Status status) {
        Complaint complaint = this.complaintDAO.getComplaintById(id);
        complaint.setStatus(status);
        return this.complaintDAO.updateComplaint(complaint);
    }


}
