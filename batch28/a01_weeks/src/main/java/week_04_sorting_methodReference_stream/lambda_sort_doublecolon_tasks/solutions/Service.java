package week_04_sorting_methodReference_stream.lambda_sort_doublecolon_tasks.solutions;

import week_04_sorting_methodReference_stream.lambda_sort_doublecolon_tasks.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Service {

        public static List<Address> getAllAddress() {
            return DataGenerator.ADDRESS_LIST;
        }

        public static List<Company> getAllCompanies() {
            return DataGenerator.COMPANY_LIST;
        }

        public static List<Employee> getAllEmployees() {
            return DataGenerator.EMPLOYEE_LIST;
        }


        //***********DEFINE YOUR NECESSARY METHODS HERE***********

        public static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
            List<T> result = new ArrayList<>();

            for (T element : elements) {
                if (predicate.test(element)) {
                    result.add(element);
                }
            }
            return result;
        }

        public static PromotedEmployee findByIdAndPromote(List<Employee> employees, Function<Employee, PromotedEmployee> function, Integer employeeId) {
            PromotedEmployee promotedEmployee = new PromotedEmployee();
            for (Employee employee : employees) {
                if (employee.getId().equals(employeeId)) {
                    promotedEmployee = function.apply(employee);
                }
            }
            return promotedEmployee;
        }


        public static <T> List<String> getSpecificAttributes(List<T> elements, Function<T, String> function) {
            List<String> nameAgeList = new ArrayList<>();
            for (T element : elements) {
                nameAgeList.add(function.apply(element));
            }

            return nameAgeList;
        }

        public static List<String> getIfFullName(List<Employee> elements, Function<Employee, String> function, Predicate<Employee> predicate) {
            List<String> fullNames = new ArrayList<>();
            for (Employee element : elements) {
                if (predicate.test(element)) {
                    fullNames.add(function.apply(element));
                }
            }

            return fullNames;
        }

        public static void printEmployeesWithAddressId(List<Employee> employees, Consumer<Employee> consumer, Integer addressId) {
            for (Employee employee : employees) {
                if (employee.getCompany().getAddress().getId().equals(addressId)) {
                    consumer.accept(employee);
                }
            }
        }

        public static void printCompaniesWithAddressId(List<Company> companies, Consumer<Company> consumer, Integer addressId) {
            for (Company company : companies) {
                if (company.getAddress().getId().equals(addressId)) {
                    consumer.accept(company);
                }
            }
        }

        public static List<PromotedEmployee> filterEmployeesAndPromote(List<Employee> employees, Predicate<Employee> predicate, Function<Employee, PromotedEmployee> function) {
            List<PromotedEmployee> promotedEmployees = new ArrayList<>();
            for (Employee employee : employees) {
                if (predicate.test(employee)) {
                    promotedEmployees.add(function.apply(employee));
                }
            }
            return promotedEmployees;
        }

        public static <T> void printAll(List<T> elements, Consumer<T> consumer) {
            for (T element : elements) {
                consumer.accept(element);
            }
        }


    }
