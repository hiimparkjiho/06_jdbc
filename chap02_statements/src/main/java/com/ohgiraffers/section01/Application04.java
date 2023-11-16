package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.Employee2DTO;
import com.ohgiraffers.model.dto.EmployeeDTO;
import com.ohgiraffers.section01.service.App4Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application04 {
    public static void main(String[] args){
        /*
        * 객체(object)는 사전적인 정의로 실제 존재하는 것을 말한다.
        * 붕어빵을 붕어빵틀 = new 붕어빵틀();
        * 사람 박지호 = new 사람();
        *
        * 개체 생물학에서의 개체는 하나의 생물체를 뜻한다.
        *
        * 사람 박지호 = new 사람(); <- 인스턴스
        * 사람 박성호 = new 사람(); <- 인스턴스
        * 형제(사람 누구);
        * 박지호.형제(박성호)
        * */

        // 기본 생성시
        Employee2DTO nonBuilder = new Employee2DTO();
        nonBuilder.setEmpId("200");
        nonBuilder.setEmpName("선동일");

        EmployeeDTO builderEmp = new EmployeeDTO()
                .setEmpNo("621235-1985634")
                .setName("선동일")
                .setBonus(0.3)
                .setEmpId("200")
                .setJobCode("J1");
        System.out.println(builderEmp);


        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("조회할 사번을 입력해주세요: ");
        String empId = scan.next();

        App4Service service = new App4Service();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '"+empId+"'";
        EmployeeDTO emp = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()){
                emp = new EmployeeDTO()
                        .setEmpNo(rset.getString("EMP_NO"))
                        .setEmpId(rset.getString("EMP_ID"))
                        .setName(rset.getString("EMP_NAME"))
                        .setEmail(rset.getString("EMAIL"))
                        .setPhone(rset.getString("PHONE"));
            }
            //service.printMeployee(rset);
            service.print(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(rset);
            close(stmt);
        }

    }
}
