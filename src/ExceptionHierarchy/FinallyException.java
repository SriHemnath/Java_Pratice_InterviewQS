package ExceptionHierarchy;

import POJO.Employee;

public class FinallyException {
    public static void main(String[] args) {
        System.out.println("calling updateEmp");
        try {
            updateEmp(new Employee("Hemnath", 27));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateEmp(Employee emp) {
        try {
            System.out.println("nothing doing");
        } finally {
            throw new RuntimeException("manually throwing exception");
        }
    }
}
