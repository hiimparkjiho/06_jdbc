package com.ohgiraffers.restaurant.model.dao;

import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.Menuvo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.ohgiraffers.restaurant.common.JDBCTemplate.*;
public class MenuDAO { // data access object
    Properties prop = new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Menuvo> findAllMenu(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<Menuvo> resultList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllMenu"));

            while(rset.next()){
                resultList.add(new Menuvo(rset.getInt(1),
                        rset.getString(2),
                        rset.getInt(3),
                        rset.getString(4),
                        rset.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(stmt);
        }
        return resultList;
    }

    /*
    * 카테고리 코드가 존재하는지 확인한다.
    * @Param Connection con
    * @Return List<Integer>
    * */
    public List<String> findAllCategoryCode(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<String> resultList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllCategory"));

            while(rset.next()){
                resultList.add(rset.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(stmt);
        }
        return resultList;
    }

    public int registMenu(Connection con, MenuDTO menuDTO) {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("insertMenu"));
            stmt.setString(1, menuDTO.getMenuName());
            stmt.setInt(2, menuDTO.getPrice());
            stmt.setString(3, menuDTO.getCategory());
            stmt.setString(4, menuDTO.getStatus());
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(stmt);
        }
        return result;
    }

    public int deleteMenu(Connection con, MenuDTO menuDTO){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(prop.getProperty("deleteMenu"));
            pstmt.setString(1, menuDTO.getMenuName());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateMenu(Connection con, MenuDTO menuDTO, String updateMenuName) {
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(prop.getProperty("updateUser"));
            pstmt.setString(1, menuDTO.getMenuName());
            pstmt.setInt(2, menuDTO.getPrice());
            pstmt.setString(3, menuDTO.getCategory());
            pstmt.setString(4, menuDTO.getStatus());
            pstmt.setString(5, updateMenuName);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt);
        }
        return result;
    }
}
