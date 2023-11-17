package com.ohgiraffers.opez.service;

import com.ohgiraffers.opez.model.dao.OpezDAO;
import com.ohgiraffers.opez.model.dto.AllUsersDTO;
import static com.ohgiraffers.opez.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

public class OpezService {
    private static OpezDAO opezDAO;

    public OpezService(String url) {
        this.opezDAO = new OpezDAO(url);
    }


    public static List<AllUsersDTO> selectAllUsers() {
        Connection con = getConnection();
        List<AllUsersDTO> userList = opezDAO.selectUsers(con);
        close(con);
        return userList;
    }
}
