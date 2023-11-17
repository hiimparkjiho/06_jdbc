package com.ohgiraffers.section03;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {
    public static void main(String[] args){
        /*
        * transaction 데이터베이스의
        * */

        Connection con = getConnection();
        try {
            con.setAutoCommit(false);
            // insert1

            // insert2

            // insert3

            con.commit();
            System.out.println("autoCommit의 현재 값 : ");
            con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
