package dev.gutierrez.daos.meeting;

import dev.gutierrez.entities.Entities.Meeting;
import dev.gutierrez.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAOPostgres implements MeetingDAO{
    @Override
    public Meeting createMeeting(Meeting meeting) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into meeting values(default, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, meeting.getAddress());
            preparedStatement.setInt(2, meeting.getTime());
            preparedStatement.setString(3, meeting.getSummary());

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedKey = rs.getInt("meeting_id");
            meeting.setMeeting_id(generatedKey);
            return meeting;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Meeting> getAllMeeting() {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from meeting";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            List<Meeting> meetingList = new ArrayList();
            while(rs.next()){
                Meeting meeting = new Meeting();

                meeting.setMeeting_id(rs.getInt("meeting_id"));
                meeting.setAddress(rs.getString("address"));
                meeting.setTime(rs.getInt("time"));
                meeting.setSummary(rs.getString("summary"));

                meetingList.add(meeting);
            }

            return meetingList;


        }catch(SQLException e){
            e.printStackTrace();
            return null;

        }
    }
}
