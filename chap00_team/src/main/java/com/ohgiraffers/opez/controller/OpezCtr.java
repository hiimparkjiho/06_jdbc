package com.ohgiraffers.opez.controller;

import com.ohgiraffers.opez.model.dto.AllUsersDTO;
import com.ohgiraffers.opez.service.OpezService;
import static com.ohgiraffers.opez.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OpezCtr {
    private OpezService opezService;

    public OpezCtr(OpezService opezService) {
        this.opezService = opezService;
    }

    public List<AllUsersDTO> selectAllUsers(){
        List<AllUsersDTO> userList = OpezService.selectAllUsers();
        if(Objects.isNull(userList)){
            return null;
        }
        return userList;
    }

    public String deleteUser(AllUsersDTO allUsersDTO){
        if(allUsersDTO.getUserName().equals("")){
            return "유저 이름을 일력해주세요";
        }
        int result = opezService.deleteUser(allUsersDTO);
        if(result < 0){
            return "관리자에게 문의해주세요";
        }
        return "유저 정보가 삭제되었습니다";
    }

    public int updateUser(AllUsersDTO allUsersDTO){
        int result = opezService.updateUser(allUsersDTO);
        return result;
    }
}
