package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application02 {

    public static void main(String[] args){

        /*
         * 사용자가 메뉴를 등록 할 수 있도록 만들어주세요
         * 등록이 완료되면 메뉴등록 성공 실패하면 다시 등록을 요청해주세요
         * */

        Scanner scr = new Scanner(System.in);

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties props = new Properties();

        System.out.println("등록하실 메뉴 명을 입력 해주세요");
        String a = scr.nextLine();
        System.out.println("메뉴의 가격을 입력 해주세요");
        int b = scr.nextInt();
        System.out.println("메뉴의 타입을 정해주세요");
        System.out.println("4.한식 5.중식 6.일식 7.퓨전");
        int c = scr.nextInt();

        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu_query.xml"));
            pstmt = con.prepareStatement(props.getProperty("insertMenu"));
            pstmt.setString(1,a);
            pstmt.setInt(2,b);
            pstmt.setInt(3,c);
            pstmt.setString(4,"Y");

            result = pstmt.executeUpdate();


            if(result ==1) {
                System.out.println("메뉴등록에 성공하였습니다.");
            }else {
                System.out.println("메뉴 등록에 실패하였습니다 다시 도전 해주세요");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(pstmt);
            scr.close();
        }


    }
}