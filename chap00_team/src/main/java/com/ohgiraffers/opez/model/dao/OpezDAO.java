package com.ohgiraffers.opez.model.dao;

import com.ohgiraffers.opez.model.dto.AllUsersDTO;
import static com.ohgiraffers.opez.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OpezDAO {
    Properties prop = new Properties();
    public OpezDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<AllUsersDTO> selectUsers(Connection con) {
        List<AllUsersDTO> userList = new ArrayList<>();
        Statement stmt = null;
        ResultSet rset = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("selectAllUsers"));
            while(rset.next()){
                userList.add(new AllUsersDTO(rset.getInt(1),
                                        rset.getString(2),
                                         rset.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(stmt);
            close(rset);
        }
        return userList;
    }

    public int userDelete(Connection con, AllUsersDTO allUsersDTO){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;

        try {
            pstmt = con.prepareStatement(prop.getProperty("deleteUser"));
            pstmt = con.prepareStatement(prop.getProperty("deleteUserFromMasterBuild"));
            pstmt = con.prepareStatement(prop.getProperty("deleteUserFromMasterUser"));
            pstmt.setString(1, allUsersDTO.getUserName());
            pstmt.setInt(2,allUsersDTO.getUserCode());
            pstmt.setInt(3,allUsersDTO.getUserCode());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(rset);
        }
        return result;
    }


    public int userUpdate(Connection con, AllUsersDTO allUsersDTO) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;

        try {
            pstmt = con.prepareStatement("updateUser");
            pstmt.setString(1, allUsersDTO.getUserName());
            pstmt.setString(2,allUsersDTO.getUserTier());
            pstmt.setString(3, allUsersDTO.getUserName());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return result;

    }
}
