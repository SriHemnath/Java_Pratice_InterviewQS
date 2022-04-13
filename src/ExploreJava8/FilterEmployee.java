package ExploreJava8;

import POJO.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class FilterEmployee {
    public static void main(String args[])
    {
        //list of employees age greate than 20
        List<Employee> employeeList = createEmployeeList();
        List<String> employeeFilteredList = employeeList.stream()
                .filter(e->e.getAge()>20)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("List of employees greater than 20:");
        employeeFilteredList.forEach((name)-> System.out.println(name));

        //count of employees age  > 25
        long count = employeeList.stream()
                .filter(e->e.getAge()>25)
                .count();
        System.out.println("Count of employees age greater than 25 "+count);

        //find employee with name Mary
        Optional<Employee> emp=employeeList.stream().filter(e->e.getName().equalsIgnoreCase("Mary")).findAny();
        if (emp.isPresent()){
            System.out.println("Employee with name Mary "+emp.get());
        }

        //find max age of employee
        OptionalInt max = employeeList.stream()
                .mapToInt(Employee::getAge).max();
        if (max.isPresent()){
            System.out.println("Maximum age of employee "+max.getAsInt());
        }

        //sort on basis of age
        System.out.println("Sorted basis on age:");
        employeeList.sort((e1,e2)->e1.getAge()-e2.getAge());
        employeeList.forEach(System.out::println);

        //Join the all employee names with “,”
        List<String> employeeNames = employeeList
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        String employeeNamesStr = String.join(",", employeeNames);
        System.out.println("Employees are: "+employeeNamesStr);

        //Given the list of employee, group them by employee name
        Map<String, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        map.forEach((name,employeeListTemp)->System.out.println("Name: "+name+" ==>"+employeeListTemp));

        //remove dups
        Integer[] arr=new Integer[]{1,2,3,4,3,2,4,2};
        List<Integer> listWithDuplicates = Arrays.asList(arr);
        List<Integer> listWithoutDups = listWithDuplicates.stream().distinct().collect(Collectors.toList());
        listWithoutDups.forEach((i)->System.out.print(" "+i));
        //also can use Collectors.toset()

        //convert to UC
        List<String> stringList = Arrays.asList("John", "Martin", "Mary", "Steve");
        System.out.println("Converting to UpperCase");
        stringList.stream()
                .map((s) -> s.toUpperCase())
                .forEach(System.out::println);

    }

    public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();

        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        return employeeList;
    }
}
