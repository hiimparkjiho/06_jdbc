package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int resullt = 0;
        Properties props = new Properties();

        System.out.println("삭제하실 메뉴 이름을 입력 해주세요");
        String a = scr.nextLine();

        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu_query.xml"));
            pstmt = con.prepareStatement(props.getProperty("deleteMenu"));
            pstmt.setString(1,a);
            resullt = pstmt.executeUpdate();

            if(resullt ==1) {
                System.out.println("메뉴삭제에 성공하였습니다.");
            }else {
                System.out.println("메뉴 삭제에 실패하였습니다 다시 도전 해주세요");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}