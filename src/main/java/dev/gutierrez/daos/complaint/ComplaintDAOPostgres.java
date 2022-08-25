package dev.gutierrez.daos.complaint;

import dev.gutierrez.entities.Entities.Complaint;
import dev.gutierrez.entities.Enum.Offense;
import dev.gutierrez.entities.Enum.Status;
import dev.gutierrez.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAOPostgres implements ComplaintDAO {
    @Override
    public Complaint createComplaint(Complaint complaint) {
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "insert into complaint values(default, ?, ?, default, 0)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, complaint.getOffense(), Types.OTHER);
            preparedStatement.setString(2, complaint.getDescription());

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedKey = rs.getInt("complaint_id");
            complaint.setComplaint_id(generatedKey);
            return complaint;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Complaint getComplaintById(int id) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from complaint where complaint_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            Complaint complaint = new Complaint();
            complaint.setComplaint_id(rs.getInt("complaint_id"));
            complaint.setOffense(Offense.valueOf(rs.getString("offense")));
            complaint.setDescription(rs.getString("description"));
            complaint.setStatus(Status.valueOf(rs.getString("status")));
            complaint.setMeeting_id(rs.getInt("meeting_id"));

            return complaint;


        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public List<Complaint> getAllComplaints() {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from complaint";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            List<Complaint> complaintList = new ArrayList();
            while(rs.next()){
                Complaint complaint = new Complaint();

                complaint.setComplaint_id(rs.getInt("complaint_id"));
                complaint.setOffense(Offense.valueOf(rs.getString("offense")));
                complaint.setDescription(rs.getString("description"));
                complaint.setStatus(Status.valueOf(rs.getString("status")));
                complaint.setMeeting_id(rs.getInt("meeting_id"));

                complaintList.add(complaint);
            }
            return complaintList;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "update complaint set status = CAST(? AS enum1), meeting_id = ? where complaint_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, complaint.getStatus(), Types.OTHER);
            preparedStatement.setInt(2, complaint.getMeeting_id());
            preparedStatement.setInt(3, complaint.getComplaint_id());

            preparedStatement.executeUpdate();
            return complaint;


        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

}