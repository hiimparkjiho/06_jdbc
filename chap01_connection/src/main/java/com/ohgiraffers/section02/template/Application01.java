package com.ohgiraffers.section02.template;
import com.ohgiraffers.section02.template.JDBCTemplate;

import java.sql.Connection;

import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;
import static com.ohgiraffers.section02.template.JDBCTemplate.close;

public class Application01 {
    public static void main(String[] args){
        Connection con = getConnection();
        System.out.println(con);
        close(con);
    }
}
