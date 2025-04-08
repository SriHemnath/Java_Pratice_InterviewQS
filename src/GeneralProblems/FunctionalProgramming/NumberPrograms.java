package GeneralProblems.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

//Print Only Odd Numbers from the List
public class PrintOddNumbers {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        intList.parallelStream().filter(n-> n%2!=0).forEach(System.out::println);

        Predicate<Integer> evenPredicate = n -> n%2==0;
        Predicate<Integer> oddPredicate = n -> n%2!=0;

        System.out.println("Even Predicate");
        IntStream.rangeClosed(1,100).filter(evenPredicate::test).forEach(System.out::println);

        System.out.println("Odd Predicate");
        IntStream.rangeClosed(1,100).filter(oddPredicate::test).forEach(System.out::println);

//        Cubes of odd number
        System.out.println("Cubes of odd number");
        intList.stream().filter(oddPredicate).map( v -> v*v*v).forEach(System.out::println);
        intList.stream().filter(oddPredicate).forEach(n-> System.out.println("Cube of "+n+" is "+n*n*n));
    }
}
