package dev.gutierrez.daotests;

import dev.gutierrez.daos.complaint.ComplaintDAO;
import dev.gutierrez.daos.complaint.ComplaintDAOPostgres;
import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.entities.Enum.Offense;
import dev.gutierrez.entities.Enum.Status;
import dev.gutierrez.utils.ConnectionUtil;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ComplaintTest {

    ComplaintDAO complaintDAO = new ComplaintDAOPostgres();

//    @Test
//    void create_complaint_test(){
//        Complaint complaint = new Complaint(3, Offense.CRIME,"JOKER STOLE MY MONEY", Status.UNREVIEWED, 0);
//        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
//        Assertions.assertNotEquals(0, savedComplaint.getComplaint_id());
//        System.out.println(complaint);
//    }

    @Test
    void get_complaint_by_id_test(){
        Complaint complaint = complaintDAO.getComplaintById(3);
        Assertions.assertEquals("CRIME", complaint.getOffense().toString());
        System.out.println(complaint);
    }

    @Test
    void get_all_complaints_test(){
        List<Complaint> complaintList = complaintDAO.getAllComplaints();
        Assertions.assertNotEquals(0, complaintList.size());
        System.out.println(complaintList);
    }

    @Test
    void update_complaint_test(){
        Complaint complaintv2 = new Complaint(3, Offense.CRIME,"JOKER STOLE MY MONEY", Status.REVIEWED, 0);
        complaintDAO.updateComplaint(complaintv2);
        Complaint complaint = complaintDAO.getComplaintById(3);
        Assertions.assertEquals("REVIEWED", complaint.getStatus().toString());
    }


}
