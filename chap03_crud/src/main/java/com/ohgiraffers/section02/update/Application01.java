package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {
    public static void main(String[] args){

        Scanner scr = new Scanner(System.in);

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int resullt = 0;
        Properties props = new Properties();

        // entry 에서는 where값이 마지막 번호

        System.out.println("변경하실 메뉴 명을 입력 해주세요");
        String a = scr.nextLine();
        System.out.println("어떤 메뉴로 변경 하시겠어요?");
        String b = scr.nextLine();
        System.out.println("바꿀 메뉴의 가격을 입력 해주세요");
        int c = scr.nextInt();
        System.out.println("바꿀 메뉴의 타입을 선택 해주세요");
        System.out.println("4.한식 5.중식 6.일식 7.퓨전");
        int d = scr.nextInt();

        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu_query.xml"));
            pstmt = con.prepareStatement(props.getProperty("updateMenu"));

            pstmt.setString(4,a);
            pstmt.setString(1, b);
            pstmt.setInt(2,c);
            pstmt.setInt(3,d);

            resullt = pstmt.executeUpdate();

            if(resullt ==1 ) {
                System.out.println("변경이 성공하였습니다.");
            }else {
                System.out.println("다시 시도 해주세요");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(pstmt);

        }

    }
}