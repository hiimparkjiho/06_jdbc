package com.ohgiraffers.section02.template;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection_info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            con = DriverManager.getConnection(url, prop);


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void close(Connection con){
        try {
            con.close();    // 추상메서드라 몸체가 없기 때문에 에러가 난다. 트라이 / 캐치문으로 던져준다.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
