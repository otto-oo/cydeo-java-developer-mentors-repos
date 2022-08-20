package com.cydeo;

import static com.cydeo.DataGenerator.*;
import static com.cydeo.Service.*;

public class Main {

    public static void main(String[] args) {
        createAllAddresses();
        createAllCompanies();
        createAllEmployees();

        //When you start to solve new question, comment out the System.out.println statement


        //EXAMPLE
        System.out.println("***get all employees if their Id number is odd");
        System.out.println(filter(getAllEmployees(), employee -> employee.getId() % 2 != 0));


        System.out.println("***get all employees if their Id number is even");
        System.out.println(filter(getAllEmployees(), employee -> employee.getId() % 2 == 0));

        System.out.println("***get all employees if they are FEMALE***");
        System.out.println(filter(getAllEmployees(), employee -> employee.getGender().equals(Gender.FEMALE)));

        System.out.println("***get all employees if they are MALE***");
        System.out.println(filter(getAllEmployees(), employee -> employee.getGender().equals(Gender.MALE)));

        System.out.println("***get all employees if they are older than 50");
        System.out.println(filter(getAllEmployees(), employee -> employee.getAge() > 50));

        System.out.println("***get all employees whose company name info starts with A or a");
        System.out.println(filter(getAllEmployees(), employee -> employee.getCompany().getCompanyName().substring(0, 1).equalsIgnoreCase("A")));

        System.out.println("*** get all employees their company is located in Utah Indiana or California as a state ");
        System.out.println(filter(getAllEmployees(), employee ->
                employee.getCompany().getAddress().getState().equals("Utah") ||
                        employee.getCompany().getAddress().getState().equals("Indiana") ||
                        employee.getCompany().getAddress().getState().equals("California")));

        System.out.println("get all companies if the company name consist of ,");
        System.out.println(filter(getAllCompanies(), company -> company.getCompanyName().contains(",")));

        System.out.println("get all companies if the company name ends with a");
        System.out.println(filter(getAllCompanies(), company -> company.getCompanyName().endsWith("a")));

        System.out.println("get all companies if their street information starts with numeric value");
        System.out.println(filter(getAllCompanies(), company -> Character.isDigit(company.getAddress().getStreet().charAt(0))));


        System.out.println("show all the employees full name and corresponding age information in one list");
        System.out.println(getSpecificAttributes(getAllEmployees(), employee -> employee.getFullName() + " | " + employee.getAge()));

        System.out.println("show all the employees street city and state information with their age in one list");
        System.out.println(getSpecificAttributes(getAllEmployees(), employee -> employee.getCompany().getAddress().getStreet() + " | " +
                employee.getCompany().getAddress().getCity() + " | " + employee.getCompany().getAddress().getState() + " | " + employee.getAge()));


        System.out.println("***get just the fullName of all employees in list if their Id number is even***");
        System.out.println(getIfFullName(getAllEmployees(), Employee::getFullName, employee -> employee.getId() % 2 == 0));

        System.out.println("***just print the employees with address id information");
        printEmployeesWithAddressId(getAllEmployees(), System.out::println, 5);

        System.out.println("***just print the companies if they are located in address id 2");
        printCompaniesWithAddressId(getAllCompanies(), System.out::println, 3);

        System.out.println("***get one employee with id and promote her/him - create an PromotedEmployee object with any information");
        System.out.println(findByIdAndPromote(getAllEmployees(), employee -> new PromotedEmployee(Role.CEO, 15000, employee), 53));

        System.out.println("***get all female employees older than 45 and promote all with 100.000 salary and manager role");
        System.out.println(filterEmployeesAndPromote(getAllEmployees(),
                employee -> employee.getGender().equals(Gender.FEMALE) & employee.getAge() > 45,
                employee -> new PromotedEmployee(Role.MANAGER, 100000, employee)));

        System.out.println("***print all employees***");
        printAll(getAllEmployees(), System.out::println);

        System.out.println("print all companies");
        printAll(getAllCompanies(), System.out::println);

        System.out.println("print all address");
        printAll(getAllAddress(), System.out::println);

        System.out.println("***SORTING QUESTIONS*** AFTER YOU HAVE DONE THE SORTING TASKS COMMENT YOUR CODE TO UNDERSTAND THE RESULT OF UPCOMING TASK");

//        System.out.println("***sort all employees with id in ascending order***");
//        getAllEmployees().sort(Comparator.comparing(Employee::getId));
//        System.out.println(getAllEmployees());

//        System.out.println("***sort all employees with id in descending order***");
//        getAllEmployees().sort(Comparator.comparing(Employee::getId).reversed());
//        System.out.println(getAllEmployees());

//        System.out.println("sort all employees with age in ascending order");
//        getAllEmployees().sort(Comparator.comparing(Employee::getAge));
//        System.out.println(getAllEmployees());

//        System.out.println("sort all employees with age in descending order");
//        getAllEmployees().sort(Comparator.comparing(Employee::getAge).reversed());
//        System.out.println(getAllEmployees());

//        System.out.println("sort all employees with company id in ascending order");
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getId()));
//        System.out.println(getAllEmployees());
    }
}
