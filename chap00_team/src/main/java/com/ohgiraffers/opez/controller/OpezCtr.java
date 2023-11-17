package com.ohgiraffers.opez.controller;

import com.ohgiraffers.opez.model.dto.AllUsersDTO;
import com.ohgiraffers.opez.service.OpezService;

import java.util.List;
import java.util.Objects;

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
}
