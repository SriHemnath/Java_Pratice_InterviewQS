package GeneralProblems.Pratice.POJO;

import java.util.ArrayList;
import java.util.List;

public class CreateEmp {
    public static void main(String[] args) {
        Employee emp = new Employee("Hemnath",27);
        System.out.println(emp);
        System.out.println(emp);
        updateEmployee(emp);
        System.out.println(emp);
        List<String> ls = new ArrayList<>();
        ls.add("Hemnath");
        ls.add("samantha");
        ls.add("alia");
        ls.add("sai pallavi");
        updateString(ls);
        System.out.println(ls);
        List<Integer> i1 = new ArrayList<>();
        i1.add(0);
        i1.add(1);
        i1.add(2);
        i1.add(3);
        updateInteger(i1);
        System.out.println(i1);

    }

    public static void updateEmployee(Employee emp) {
        emp.setName("Samantha");
    }

    public static void updateString(List<String> emp) {
        emp.set(0,"Malavika");
    }

    public static void updateInteger(List<Integer> emp) {
        emp.set(0,10);
    }
}
