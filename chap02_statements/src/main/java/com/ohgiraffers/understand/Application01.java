package com.ohgiraffers.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {
    public static void main(String[] args){
        Connection con = getConnection();
        ResultSet rset1 = null;
        ResultSet rset2 = null;
        Statement stmt1 = null;
        Statement stmt2 = null;
        try {
            stmt1 = con.createStatement();
            String quiz1 = "SELECT " +
                                "E.EMP_ID, " +
                                "E.EMP_NAME, " +
                                "E.PHONE, " +
                                "J.JOB_NAME " +
                            "FROM employee AS E " +
                            "JOIN job AS j " +
                            "ORDER BY SALARY DESC " +
                            "LIMIT 0,1";
            rset1 = stmt1.executeQuery(quiz1);
            while(rset1.next()){
                System.out.println(rset1.getString("E.EMP_ID") + " " + rset1.getString("E.PHONE") + " "+ rset1.getString("E.EMP_NAME")+ " " + rset1.getString("J.JOB_NAME"));
            }
            stmt2 = con.createStatement();
            String quiz2 = "SELECT " +
                    "E.EMP_ID, " +
                    "E.EMP_NAME, " +
                    "E.PHONE, " +
                    "J.JOB_NAME " +
                    "FROM employee AS E " +
                    "JOIN job AS J ON E.JOB_CODE = J.JOB_CODE " +
                    "WHERE E.EMP_NAME = '선동일'";
            rset2 = stmt2.executeQuery(quiz2);

            while(rset2.next()){
                System.out.println(
                        rset2.getString("E.EMP_ID") + " " + rset2.getString("E.EMP_NAME") + " " + rset2.getString("E.PHONE") + " "
                                + rset2.getString("J.JOB_NAME")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

        }  finally{
            close(stmt1);
            close(stmt2);
            close(rset1);
            close(rset2);
            close(con);
        }


    }
}
