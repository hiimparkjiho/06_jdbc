package com.ohgiraffers.opez.view;

import com.ohgiraffers.opez.controller.OpezCtr;
import com.ohgiraffers.opez.model.dto.AllUsersDTO;
import com.ohgiraffers.opez.service.OpezService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainView {
    public static void RunApp(){
        Scanner scan = new Scanner(System.in);
        OpezCtr opezCtr = new OpezCtr(new OpezService("src/main/resources/mapper/connection_info.xml"));

        while(true){
            System.out.println("opez 회원 정보 조회");
            System.out.println("1.유저 정보 조회 \n 2.장인정보 조회");
            int num = scan.nextInt();
            switch (num){
                case 1: viewAllUsers(opezCtr.selectAllUsers()); break;
                //case 2: viewMasterUsers(); break;
                default: break;
            }

        }
    }

    public static void viewAllUsers(List<AllUsersDTO> userList){
        if(Objects.isNull(userList)){
            System.out.println("오류가 발생했습니다 관리자에게 문의해주세요");
        }else if(userList.size() < 0){
            System.out.println("등록된 유저가 없습니다.");
        }else{
            for (AllUsersDTO opezUser: userList) {
                System.out.println(opezUser);
            }
        }
    }

    public static void viewMasterUsers(List<>)
}
