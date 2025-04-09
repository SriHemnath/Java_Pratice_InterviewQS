package GeneralProblems.FunctionalProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

//Print Only Odd Numbers from the List
public class NumberPrograms {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        intList.parallelStream().filter(n -> n % 2 != 0).forEach(System.out::println);

        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        Predicate<Integer> oddPredicate = n -> n % 2 != 0;

        System.out.println("Even Predicate");
        IntStream.rangeClosed(1, 100).filter(evenPredicate::test).forEach(System.out::println);

        System.out.println("Odd Predicate");
//        IntStream.rangeClosed(1, 100).filter(oddPredicate::test).forEach(System.out::println);
        IntStream.rangeClosed(1, 100).filter(oddPredicate::test).forEach(NumberPrograms::print);

//        Cubes of odd number
        System.out.println("Cubes of odd number");
        intList.stream().filter(oddPredicate).map(v -> v * v * v).forEach(System.out::println);
        intList.stream().filter(oddPredicate).forEach(n -> System.out.println("Cube of " + n + " is " + n * n * n));

//        Square every number in a list and find the sum of squares
        ToIntFunction<Integer> squareNumber = n -> n * n;
        int sumOfSquares = intList.parallelStream().mapToInt(squareNumber).sum();
        System.out.println("Sum of squares: " + sumOfSquares);

//        Cube every number in a list and find the sum of squares
        ToIntFunction<Integer> cubeNumber = n -> n * n * n;
        int sumOfCubes = intList.parallelStream().mapToInt(cubeNumber).sum();
//        int sumOfCubes = intList.parallelStream().map(n->n*n*n).reduce(0,Integer::sum);
        System.out.println("Sum of cubes: " + sumOfCubes);

//        Find Sum of Odd Numbers in a list
        int sumOfOddNumbers = intList.parallelStream().filter(oddPredicate).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of odd numbers: " + sumOfOddNumbers);

//        Find Sum of Even Numbers in a list
        Optional<Integer> sumEven = intList.stream().reduce((sum, num) -> num % 2 == 0 ? sum + num : sum);
        System.out.println("Sum of even numbers: " + sumEven.orElse(0));

//        Create a List with Even Numbers Filtered from the Numbers List
        List<Integer> evenNumbs = intList.stream().filter(NumberPrograms::isEven).toList();
        System.out.println(evenNumbs);

//        find max value
        int maxvalue = intList.stream().max(Integer::compare).orElse(0);
        int min = intList.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println("Max value: "+maxvalue+", Minimum value: "+min);
    }

    private static void print(int number) {
        System.out.println(number); // Print the number
    }

    private static boolean isEven(int number) {
        return number%2==0;
    }
}
