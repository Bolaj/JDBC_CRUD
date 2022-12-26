package org.example;

import org.example.model.Employee;
import org.example.service.DatabaseService;

import java.util.Scanner;

public class JavaCrud {
    public static void main(String[] args) {

        DatabaseService databaseService = new DatabaseService();
        try(Scanner scanner = new Scanner(System.in);)
        {
            boolean isRunning = true;
            while(true)
            {
                System.out.println("Please, select your option");
                System.out.println(".................................");
                System.out.println("[1]. Insert");
                System.out.println("[2]. Select All");
                System.out.println("[3]. Select Employee By ID");
                System.out.println("[4]. Delete Employee");
                System.out.println("[5]. Update Employee");
                System.out.println("[6]: Exit");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice)
                {
                    case 1:
                        System.out.println("Enter name, address, and salary ");
                        databaseService.insertEmployee(new Employee(scanner.nextLine(), scanner.nextLine(),
                                Double.parseDouble(scanner.nextLine())));

                        break;
                    case 2:

                        databaseService.getAllEmployees();
                        break;
                    case 3:

                        System.out.println("Enter ID of an Employee");
                        databaseService.getEmployeeByID(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6 :

                        System.out.println("Thank You, Visit Again");
                        isRunning = false;
                        break;

                    default:
                        break;

                }

            }


        }catch (Exception e){
            throw new RuntimeException("Somethin Went Wrong" + e);
        }

    }
}