package com.ohgiraffers.restaurant.service;

import com.ohgiraffers.restaurant.model.dao.MenuDAO;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.Menuvo;
import static com.ohgiraffers.restaurant.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

public class MenuService {
    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO(url);
    }

    public List<Menuvo> findMenu(){
        // DB 연결
        Connection con = getConnection();
        // business logic Ex) price > 0

        List<Menuvo> list = menuDAO.findAllMenu(con);

        close(con);
        return list;
    }

    public int registMenu(MenuDTO menuDTO) {
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);
        if(!category.contains(menuDTO.getCategory())){
            return 0;
        }

        if(menuDTO.getPrice() <= 1000){
            return 0;
        }

        int result = menuDAO.registMenu(con, menuDTO);

        close(con);

        return result;
    }

    public int deleteMenu(MenuDTO menuDTO){
        Connection con = getConnection();
        int result = menuDAO.deleteMenu(con, menuDTO);
        return result;
    }
}
