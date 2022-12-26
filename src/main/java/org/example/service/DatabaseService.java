package org.example.service;


import org.example.jdbc.util.DatabaseUtil;
import org.example.jdbc.util.QueryUtil;
import org.example.model.Employee;

import java.sql.*;

public class DatabaseService {
    DatabaseUtil databaseUtil = new DatabaseUtil();
    public void insertEmployee(Employee employee) throws SQLException {

        try(Connection connection = databaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertEmployeeQuery());)
        {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeAddress());
            preparedStatement.setDouble(3, employee.getEmployeeSalary());

           // preparedStatement.executeUpdate();
            int rows = preparedStatement.executeUpdate();
            if(rows > 0 )
            {
                System.out.println("Record Created Successfully");
            }else{
                System.out.println("Record Insert Failed..");
            }


        }


    }//End of insertEmployee
    public void getAllEmployees() throws SQLException
    {
        try(Connection connection = databaseUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery());
            )
        {
            while(resultSet.next()){
                printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
                        resultSet.getString("EMPLOYEE_NAME"),
                        resultSet.getString("EMPLOYEE_ADDRESS"),
                        resultSet.getDouble("EMPLOYEE_SALARY")
                        ));
            }

        }
    }//End of getAllEmployees
    private void printEmployee(Employee employee)
    {
        System.out.println("Employee ID: " +employee.getEmployeeId());
        System.out.println("Employee Name: "+employee.getEmployeeName());
        System.out.println("Employee Address: "+employee.getEmployeeAddress());
        System.out.println("Employee Salary: "+employee.getEmployeeSalary());
        System.out.println("------------------------------------------");
    }//End of getAllEmployees
    public boolean getEmployeeByID(int id) throws SQLException
    {
        boolean isFound = false;
        try(Connection connection = databaseUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QueryUtil.selectEmployeeById(id));

        )
        {
            if(resultSet.next())
            {
                isFound = true;
                printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
                        resultSet.getString("EMPLOYEE_NAME"),
                        resultSet.getString("EMPLOYEE_ADDRESS"),
                        resultSet.getDouble("EMPLOYEE_SALARY")
                ));

            }else {
                System.out.println("Record Not Found for ID " +id);
            }

        }

        return isFound;
    }//End of getEmployeeByID
    public void deleteEmployeeById(int employeeId) throws SQLException
    {
        try(Connection connection = databaseUtil.getConnection();
        Statement statement = connection.createStatement();

        )
        {
         int rows =   statement.executeUpdate(QueryUtil.deleteEmployeeById(employeeId));
         if (rows > 0){
             System.out.println("Record Deleted Successfully");
         }else{
             System.out.println("Something Went Wrong..");
         }

        }
    }

}
