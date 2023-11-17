package com.ohgiraffers.opez.model.dao;

import com.ohgiraffers.opez.model.dto.AllUsersDTO;
import static com.ohgiraffers.opez.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


}
