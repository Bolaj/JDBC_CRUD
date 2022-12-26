package org.example.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:8889/jdbc_crud";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public DatabaseUtil(){
        try{
            Class.forName(DRIVER_PATH);
        }catch (Exception e){
            throw new RuntimeException("Something Went Wrong" + e);
        }


    }//End of Constructor
    public Connection getConnection()throws SQLException
    {
      return  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

    }//End of getConnection


}
