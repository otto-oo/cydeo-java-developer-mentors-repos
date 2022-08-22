package com.example.streampracticewithsolutions.practice;

import com.example.streampracticewithsolutions.model.*;
import com.example.streampracticewithsolutions.service.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Practice {

    public static CountryService countryService;
    public static DepartmentService departmentService;
    public static EmployeeService employeeService;
    public static JobHistoryService jobHistoryService;
    public static JobService jobService;
    public static LocationService locationService;
    public static RegionService regionService;

    public Practice(CountryService countryService, DepartmentService departmentService,
                    EmployeeService employeeService, JobHistoryService jobHistoryService,
                    JobService jobService, LocationService locationService,
                    RegionService regionService) {

        Practice.countryService = countryService;
        Practice.departmentService = departmentService;
        Practice.employeeService = employeeService;
        Practice.jobHistoryService = jobHistoryService;
        Practice.jobService = jobService;
        Practice.locationService = locationService;
        Practice.regionService = regionService;

    }

    // You can use the services above for all the CRUD (create, read, update, delete) operations.
    // Above services have all the required methods.
    // Also, you can check all the methods in the ServiceImpl classes inside the service.impl package, they all have explanations.

    // Display all the employees
    public static List<Employee> getAllEmployees() {
        return employeeService.readAll();
    }

    // Display all the countries
    public static List<Country> getAllCountries() {
        return countryService.readAll();
    }

    // Display all the departments
    public static List<Department> getAllDepartments() {
        return departmentService.readAll();
    }

    // Display all the jobs
    public static List<Job> getAllJobs() {
        return jobService.readAll();
    }

    // Display all the locations
    public static List<Location> getAllLocations() {
        return locationService.readAll();
    }

    // Display all the regions
    public static List<Region> getAllRegions() {
        return regionService.readAll();
    }

    // Display all the job histories
    public static List<JobHistory> getAllJobHistories() {
        return jobHistoryService.readAll();
    }

    // Display all the employees' first names
    public static List<String> getAllEmployeesFirstName() {
        return getAllEmployees().stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    // Display all the countries' names
    public static List<String> getAllCountryNames() {
        return getAllCountries().stream()
                .map(Country::getCountryName)
                .collect(Collectors.toList());
    }

    // Display all the departments' managers' first names
    public static List<String> getAllDepartmentManagerFirstNames() {
        return getAllDepartments().stream()
                //.map(department -> department.getManager().getFirstName())
                .map(Department::getManager)
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    // Display all the departments where manager name of the department is 'Steven'
    public static List<Department> getAllDepartmentsWhichManagerFirstNameIsSteven() {
        return getAllDepartments().stream()
                .filter(department -> department.getManager().getFirstName().equals("Steven"))
                .collect(Collectors.toList());
    }

    // Display all the departments where postal code of the location of the department is '98199'
    public static List<Department> getAllDepartmentsWhereLocationPostalCodeIs98199() {
        return getAllDepartments().stream()
                .filter(department -> department.getLocation().getPostalCode().equals("98199"))
                .collect(Collectors.toList());
    }

    // Display the region of the IT department
    public static Region getRegionOfITDepartment() throws Exception {
//        return getAllDepartments().stream()
//                .filter(department -> department.getDepartmentName().equals("IT"))
//                .map(department -> department.getLocation().getCountry().getRegion())
//                .findAny().orElseThrow(() -> new Exception("Region not found exception"));
        return getAllDepartments().stream()
                .filter(department -> department.getDepartmentName().equals("IT"))
                .findAny().orElseThrow(() -> new Exception("No Department Found")).getLocation().getCountry().getRegion();
    }

    // Display all the departments where the region of department is 'Europe'
    public static List<Department> getAllDepartmentsWhereRegionOfCountryIsEurope() {
        return getAllDepartments().stream()
                .filter(department -> department.getLocation().getCountry().getRegion().getRegionName().equals("Europe"))
                .collect(Collectors.toList());
    }

    // Display if there is any employee with salary less than 1000. If there is none, the method should return true
    public static boolean checkIfThereIsNoSalaryLessThan1000() {
        return getAllEmployees().stream()
                .noneMatch(employee -> employee.getSalary() < 1000);
    }

    // Check if the salaries of all the employees in IT department are greater than 2000 (departmentName: IT)
    public static boolean checkIfThereIsAnySalaryGreaterThan2000InITDepartment() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().getDepartmentName().equals("IT"))
                .allMatch(employee -> employee.getSalary() > 2000);
    }

    // Display all the employees whose salary is less than 5000
    public static List<Employee> getAllEmployeesWithLessSalaryThan5000() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() < 5000)
                .collect(Collectors.toList());
    }

    // Display all the employees whose salary is between 6000 and 7000
    public static List<Employee> getAllEmployeesSalaryBetween() {
//        return getAllEmployees().stream()
//                .filter(employee -> employee.getSalary() > 6000 && employee.getSalary() < 7000)
//                .collect(Collectors.toList());
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > 6000)
                .filter(employee -> employee.getSalary() < 7000)
                .collect(Collectors.toList());
    }

    // Display the salary of the employee Grant Douglas (lastName: Grant, firstName: Douglas)
    public static Long getGrantDouglasSalary() throws Exception {
        return getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().equals("Douglas"))
                .filter(employee -> employee.getLastName().equals("Grant"))
                .findFirst().orElseThrow(() -> new Exception("Salary does not exist")).getSalary();
    }

    // Display the maximum salary an employee gets
    public static Long getMaxSalary() throws Exception {
//        return getAllEmployees().stream()
//                .map(Employee::getSalary)
//                .reduce(Long::max).orElseThrow();

//        return getAllEmployees().stream()
//                .map(Employee::getSalary)
//                .reduce((a, b) -> a > b ? a : b).orElseThrow();

        return getAllEmployees().stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new Exception("Salary Does Not exist")).getSalary();

//        return getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .findFirst()
//                .orElseThrow(() -> new Exception("Salary Does Not exist")).getSalary();

    }

    // Display the employee(s) who gets the maximum salary
    public static List<Employee> getMaxSalaryEmployee() {
        return getAllEmployees().stream()
                .filter(employee -> {
                    try {
                        return employee.getSalary().equals(getMaxSalary());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }).collect(Collectors.toList());
    }

    // Display the max salary employee's job
    public static Job getMaxSalaryEmployeeJob() throws Exception {
        return getAllEmployees().stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new Exception("Job Does Not Exist")).getJob();
    }

    // Display the max salary in Americas Region
    public static Long getMaxSalaryInAmericasRegion() throws Exception {
        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment()
                        .getLocation().getCountry().getRegion().getRegionName().equals("Americas"))
                .map(Employee::getSalary)
                .reduce(Long::max).orElseThrow(() -> new Exception("Something went wrong"));
    }

    // Display the second maximum salary an employee gets
    public static Long getSecondMaxSalary() throws Exception {
//        List<Long> collect = getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .distinct()
//                .map(Employee::getSalary)
//                .limit(2)
//                .collect(Collectors.toList());
//
//        return collect.get(1);

        return getAllEmployees().stream()
                .map(Employee::getSalary)
                .reduce((a, b) -> {
                    try {
                        return a > b && a < getMaxSalary() ? a : b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return -1L;
                }).orElseThrow(() -> new Exception("Employee could not be found"));


    }

    // Display the employee(s) who gets the second maximum salary
    public static List<Employee> getSecondMaxSalaryEmployee() {

        return getAllEmployees().stream()
                .filter(employee -> {
                    try {
                        return employee.getSalary().equals(getSecondMaxSalary());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    // Display the minimum salary an employee gets
    public static Long getMinSalary() throws Exception {
        return getAllEmployees().stream()
                .min(Comparator.comparing(Employee::getSalary))
                .map(Employee::getSalary).orElseThrow(() -> new Exception("Something wrong"));


    }

    // Display the employee(s) who gets the minimum salary
    public static List<Employee> getMinSalaryEmployee() {
        return getAllEmployees().stream()
                .filter(employee -> {
                    try {
                        return employee.getSalary().equals(getMinSalary());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    // Display the second minimum salary an employee gets
    public static Long getSecondMinSalary() throws Exception {
//        List<Long> collect = getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .distinct()
//                .map(Employee::getSalary)
//                .limit(2)
//                .collect(Collectors.toList());
//        return collect.get(1);

        return getAllEmployees().stream()
                .map(Employee::getSalary)
                .reduce((a, b) -> {
                    try {
                        return a < b && a > getMinSalary() ? a : b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return -1L;
                })
                .orElseThrow(() -> new Exception("Something went wrong!"));

    }

    // Display the employee(s) who gets the second minimum salary
    public static List<Employee> getSecondMinSalaryEmployee() {
        return getAllEmployees().stream()
                .filter(employee -> {
                    try {
                        return employee.getSalary().equals(getSecondMinSalary());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    // Display the average salary of the employees
    public static Double getAverageSalary() {
        return getAllEmployees().stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

//        return getAllEmployees().stream()
//                .mapToDouble(Employee::getSalary)
//                .average().orElse(-1d);
    }

    // Display all the employees who are making more than average salary
    public static List<Employee> getAllEmployeesAboveAverage() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees who are making less than average salary
    public static List<Employee> getAllEmployeesBelowAverage() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() < getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees separated based on their department id number
    public static Map<Long, List<Employee>> getAllEmployeesForEachDepartment() {
        return getAllEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getId()));

    }


    // Display the total number of the departments
    public static Long getTotalDepartmentsNumber() {
//        return getAllDepartments().stream()
//                .count();

        return (long) getAllDepartments().size();
    }

    // Display the employee whose first name is 'Alyssa' and manager's first name is 'Eleni' and department name is 'Sales'
    public static Employee getEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales() throws Exception {
        return getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().equals("Alyssa") && employee.getManager()
                        .getFirstName().equals("Eleni") && employee.getDepartment().getDepartmentName().equals("Sales"))
                .findFirst().orElseThrow(() -> new Exception("Employee is not found!"));
    }

    // Display all the job histories in ascending order by start date
    public static List<JobHistory> getAllJobHistoriesInAscendingOrder() {
        return getAllJobHistories().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate))
                .collect(Collectors.toList());
    }

    // Display all the job histories in descending order by start date
    public static List<JobHistory> getAllJobHistoriesInDescendingOrder() {
        return getAllJobHistories().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    // Display all the job histories where the start date is after 01.01.2005
    public static List<JobHistory> getAllJobHistoriesStartDateAfterFirstDayOfJanuary2005() {
        return getAllJobHistories().stream()
                .filter(jobHistory -> jobHistory.getStartDate().isAfter(LocalDate.of(2005, 1, 1)))
                .collect(Collectors.toList());
    }

    // Display all the job histories where the end date is 31.12.2007 and the job title of job is 'Programmer'
    public static List<JobHistory> getAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer() {
        return getAllJobHistories().stream()
                .filter(jobHistory -> jobHistory.getEndDate().equals(LocalDate.of(2007, 12, 31))
                        && jobHistory.getJob().getJobTitle().equals("Programmer"))
                .collect(Collectors.toList());
    }

    // Display the employee whose job history start date is 01.01.2007 and job history end date is 31.12.2007 and department's name is 'Shipping'
    public static Employee getEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping() throws Exception {
        return getAllJobHistories().stream()
                .filter(jobHistory -> jobHistory.getStartDate().equals(LocalDate.of(2007, 1, 1))
                        && jobHistory.getEndDate().equals(LocalDate.of(2007, 12, 31))
                        && jobHistory.getDepartment().getDepartmentName().equals("Shipping"))
                .findFirst()
                .orElseThrow(() -> new Exception("Employee is not found"))
                .getEmployee();
    }

    // Display all the employees whose first name starts with 'A'
    public static List<Employee> getAllEmployeesFirstNameStartsWithA() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // Display all the employees whose job id contains 'IT'
    public static List<Employee> getAllEmployeesJobIdContainsIT() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getJob().getId().contains("IT"))
                .collect(Collectors.toList());
    }

    // Display the number of employees whose job title is programmer and department name is 'IT'
    public static Long getNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getJob().getJobTitle().equals("Programmer") && employee.getDepartment().getDepartmentName().equals("IT"))
                .count();
    }

    // Display all the employees whose department id is 50, 80, or 100
    public static List<Employee> getAllEmployeesDepartmentIdIs50or80or100() {
        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().getId().equals(50L)
                        || employee.getDepartment().getId().equals(80L)
                        || employee.getDepartment().getId().equals(100L))
                .collect(Collectors.toList());
    }

    // Display the initials of all the employees
    // Note: You can assume that there is no middle name
    public static List<String> getAllEmployeesInitials() {
        return getAllEmployees().stream()
                .map(employee -> employee.getFirstName().charAt(0) + String.valueOf(employee.getLastName().charAt(0)))
                .collect(Collectors.toList());
    }

    // Display the full names of all the employees
    public static List<String> getAllEmployeesFullNames() {
        return getAllEmployees().stream()
                .map(employee -> {
                    String firstName = employee.getFirstName();
                    String lastName = employee.getLastName();
                    return firstName + " " + lastName;
                })
                .collect(Collectors.toList());
    }

    // Display the length of the longest full name(s)
    public static Integer getLongestNameLength() {
        return getAllEmployeesFullNames().stream()
                .map(String::length)
                .reduce(Integer::max).orElse(-1);


    }

    // Display the employee(s) with the longest full name(s)
    public static List<Employee> getLongestNamedEmployee() {
        return getAllEmployees().stream()
                .filter(employee -> (employee.getFirstName() + " " + employee.getLastName()).length() == getLongestNameLength())
                .collect(Collectors.toList());
    }

    // Display all the employees whose department id is 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIs90or60or100or120or130() {
        return getAllEmployees().stream()
                .filter(employee ->
                        employee.getDepartment().getId() == 60 ||
                                employee.getDepartment().getId() == 90 ||
                                employee.getDepartment().getId() == 100 ||
                                employee.getDepartment().getId() == 120 ||
                                employee.getDepartment().getId() == 130).collect(Collectors.toList());
    }

    // Display all the employees whose department id is NOT 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIsNot90or60or100or120or130() {
        return getAllEmployees().stream()
                .filter(employee ->
                        employee.getDepartment().getId() != 60 &&
                                employee.getDepartment().getId() != 90 &&
                                employee.getDepartment().getId() != 100 &&
                                employee.getDepartment().getId() != 120 &&
                                employee.getDepartment().getId() != 130).collect(Collectors.toList());
    }

}
