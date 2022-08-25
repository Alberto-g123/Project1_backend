package dev.gutierrez.daos.appuser;

import dev.gutierrez.entities.Entities.AppUser;
import dev.gutierrez.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserDAOPostgres implements AppUserDAO{
    @Override
    public AppUser getUserByUserName(String username) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from app_user where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();
            rs.next();

            AppUser appUser = new AppUser();
            appUser.setUser_id(rs.getInt("user_id"));
            appUser.setFname(rs.getString("fname"));
            appUser.setLname(rs.getString("fname"));
            appUser.setUsername(rs.getString("username"));
            appUser.setPassword(rs.getString("password"));
            appUser.setRole(rs.getString("role"));

            return appUser;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
