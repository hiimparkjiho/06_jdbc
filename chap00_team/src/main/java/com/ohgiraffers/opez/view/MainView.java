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

        opez:while(true){
            System.out.println("opez 회원 정보 조회");
            System.out.println("1.유저 정보 조회 \n2.유저 삭제");
            int num = scan.nextInt();
            switch (num){
                case 1: viewAllUsers(opezCtr.selectAllUsers()); break;
                case 2:
                    //System.out.println(opezCtr.deleteUser(deleteUser()));; break;
                default: break opez;
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

//    public static AllUsersDTO deleteUser(){
//        AllUsersDTO allUsersDTO = new AllUsersDTO();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("삭제할 유저 이름을 입력해주세요.");
//        allUsersDTO.setUserName(scan.nextLine());
//
//        return allUsersDTO;
//    }

//    public static String updateUser(AllUsersDTO allUsersDTO){
//
//        System.out.println("수정할 유저의 닉네임을 입력하세요.");
//        if(allUsersDTO.getUserName().isEmpty() || allUsersDTO.getUserName().equals("")){
//            return "유저 닉네임을 입력해주세요";
//        }
//        if(allUsersDTO.getUserTier().isEmpty() || allUsersDTO.getUserTier().equals("")){
//            return "티어를 입력해주세요";
//        }
//
//        opezCtr
//
//    }


}
