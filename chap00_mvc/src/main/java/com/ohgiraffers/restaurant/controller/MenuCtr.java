package com.ohgiraffers.restaurant.controller;

import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.Menuvo;
import com.ohgiraffers.restaurant.service.MenuService;

import java.util.List;
import java.util.Objects;

public class MenuCtr {
    /*
    * 사용자의 요청을 받아
    * 유효성 체크를 하고 요청을 service로 전달하고,
    * 이후 service의 반환값을 페이지로 변환한다.
    * */

    private MenuService menuService;

    public MenuCtr(MenuService menuService){
        this.menuService = menuService;
    }
    public List<Menuvo> findAllMenu(){
        // 값을 확인한다.
        List<Menuvo> list = menuService.findMenu();

        // 반환값 확인 후 응답 값을 지정
        if(Objects.isNull(list)){
            return null;
        }
        return list;
    }

    public int modifyMenu(int code){
        System.out.println("modify code: " + code);
        return 0;
    }

    public String registMenu(MenuDTO menuDTO){
        if(Objects.isNull(menuDTO)){
            System.out.println("메뉴가 없네요");
            return "메뉴 정보가 존재하지 않습니다";
        }
        if(menuDTO.getMenuName() == null || menuDTO.getMenuName().equals("")){
            return "메뉴 이름을 등록해주세요.";
        }
        if(menuDTO.getPrice() <= 0){
            return "메뉴 가격은 음수일 수 없습니다.";
        }
        if(menuDTO.getCategory() == null || menuDTO.getCategory().equals("")){
            return "카테고리는 필수입니다.";
        }
        if(menuDTO.getStatus() == null || menuDTO.getStatus().equals("")){
            return "판매여부 등록은 필수입니다";
        }
        // 유효성 검사가 끝난 메뉴
        int result = menuService.registMenu(menuDTO);

        if(result <= 0){
            return "등록 중 오류가 발생됨";
        }else{
            return "등록완료";
        }

    }

    public String deleteMenu(MenuDTO menuDTO){

       if(menuDTO.getMenuName().equals("")){
          return "삭제할 메뉴의 이름을 입력해주세요";
       }
        int result = menuService.deleteMenu(menuDTO);
        if(result < 0){
            return "삭제되지 않았습니다.";
        }
        return "삭제 완료";
    }
}
