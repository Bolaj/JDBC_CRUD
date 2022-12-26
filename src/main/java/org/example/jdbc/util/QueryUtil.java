package org.example.jdbc.util;

public class QueryUtil {
    public static String insertEmployeeQuery(){

      return  "INSERT INTO EMPLOYEE_INFO(EMPLOYEE_NAME, EMPLOYEE_ADDRESS, EMPLOYEE_SALARY) " +
                "VALUES (?,?,?)";
    }//End of insertEmployeeQuery
    public static  String selectAllEmployeeQuery()
    {
        return "SELECT * FROM EMPLOYEE_INFO";
    }
}
