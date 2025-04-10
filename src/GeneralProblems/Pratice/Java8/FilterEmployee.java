package GeneralProblems.Pratice.Java8;

import GeneralProblems.Pratice.POJO.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class FilterEmployee {
    public static void main(String args[])
    {

        List<Employee> employeeList = createEmployeeList();

        //list of employees age greater than 20
        List<String> employeeFilteredList = employeeList.stream()
                .filter(e->e.getAge()>20)
                .map(Employee::getName)
                .toList();

        System.out.println("List of employees greater than 20:");
        employeeFilteredList.forEach(System.out::println);

        //count of employees age  > 25
        long count = employeeList.stream()
                .filter(e->e.getAge()>25)
                .count();
        System.out.println("Count of employees age greater than 25 "+count);

        //find employee with name Mary
        Optional<Employee> emp=employeeList.stream().filter(e->e.getName().equalsIgnoreCase("Mary")).findAny();
        emp.ifPresent(employee -> System.out.println("Employee with name Mary " + employee));
        //replace with function style
//        if (emp.isPresent()){
//            System.out.println("Employee with name Mary "+emp.get());
//        }

        //find max age of employee
        OptionalInt max = employeeList.stream()
                .mapToInt(Employee::getAge).max();
        if (max.isPresent()){
            System.out.println("Maximum age of employee "+max.getAsInt());
        }
        max.ifPresentOrElse( v -> System.out.println("Max age: "+v),()-> System.out.println("no employee"));

        //sort on basis of age
        System.out.println("Sorted basis on age:");
        //employeeList.sort((e1,e2)->e1.getAge()-e2.getAge());
        employeeList.sort(Comparator.comparingInt(Employee::getAge));  //both lines perform same operation
        employeeList.forEach(System.out::println);

        //sort in decreasing order of age and then in name
        System.out.println("Sorting in reverse order based on Age:");
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed().thenComparing(Employee::getName)).forEach(System.out::println);

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
        List<Integer> listWithoutDups = listWithDuplicates.stream().distinct().toList();
        listWithoutDups.forEach((i)->System.out.print(" "+i));
        //also can use Collectors.toset()

        //convert to UC
        List<String> stringList = Arrays.asList("John", "Martin", "Mary", "Steve");
        System.out.println("Converting to UpperCase");
        stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

    public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();

        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Marlin",31);
        Employee e5=new Employee("Mouse",31);
        Employee e6=new Employee("Stephan",18);
        Employee e7=new Employee("Gary",26);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);

        return employeeList;
    }
}
