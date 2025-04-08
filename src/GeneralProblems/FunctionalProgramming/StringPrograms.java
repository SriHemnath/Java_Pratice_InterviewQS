package GeneralProblems.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;

public class StringPrograms {
    public static void main(String[] args) {
        //        Print all courses individually
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.forEach(System.out::println);

//        Print Courses Containing the word "Spring"
        System.out.println("List with word Spring:");
        courses.stream().map(String::toLowerCase).filter(s -> s.contains("spring")).forEach(System.out::println);

//        Print Courses Whose Name has atleast 4 letters
        System.out.println("Print Courses Whose Name has atleast 4 letters");
        courses.stream().filter(s -> s.length() > 4).forEach(System.out::println);

//        Print the number of characters in each course name
//        courses.parallelStream().forEach(s -> System.out.println("Character in course "+s+" is "+s.length()));
        courses.forEach(s -> {
                    long count = Arrays.stream(s.split("")).distinct().count();
                    System.out.println("Count of word " + s + " is " + count);
                }

        );
    }
}
