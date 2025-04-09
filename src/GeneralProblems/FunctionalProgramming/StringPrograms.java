package GeneralProblems.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        playingWithCourse();
    }

    private static void playingWithCourse() {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("Microservices", "Microservices", 97, 22000),
                new Course("FullStack", "FullStack", 96, 25000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 91, 14000),
                new Course("Docker", "Cloud", 90, 20000),
                new Course("Kubernetes", "Cloud", 89, 20000)
        );

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.reviewScore() > 90;
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.reviewScore() > 95;
        boolean noneGreaterThan95 = courses.stream().noneMatch(reviewScoreGreaterThan95Predicate);
        System.out.println(noneGreaterThan95); // Expected output: false

        Comparator<Course> compareByStudentsAndReviewScore = Comparator.comparing(Course::numberOfStudents).thenComparing(Course::reviewScore);

        List<Course> sortedCourse = courses.stream().sorted(compareByStudentsAndReviewScore).toList();
        System.out.println(sortedCourse);

        Optional<Course> highestCourse = courses.stream().max(compareByStudentsAndReviewScore);
        System.out.println(highestCourse.get());

        Optional<Course> k = courses.stream().filter(v -> v.reviewScore() <= 90).min(compareByStudentsAndReviewScore);
        System.out.println(k);//prints Kubernetes

        int numOfStudentsReviewGT95 = courses.stream().filter(v -> v.reviewScore() > 95).mapToInt(Course::numberOfStudents).sum();
        System.out.println(numOfStudentsReviewGT95);

        Map<String, List<Course>> groupByCategory = courses.stream().collect(Collectors.groupingBy(Course::category));
        System.out.println(groupByCategory);

//      Counting Courses in Each Category
        Map<String, Long> courseCountByCategory
                = courses.stream().collect(Collectors.groupingBy(Course::category, Collectors.counting()));
        System.out.println(courseCountByCategory);

        //    Finding the Course with the Highest Review Score in Each Category
        Map<String,Optional<Course>> highestReviewScoreByCategory=
                courses.stream().
                        collect(Collectors.groupingBy(
                                Course::category,Collectors.maxBy(
                                        Comparator.comparing(Course::reviewScore))));
        System.out.println(highestReviewScoreByCategory);

//Extracting Only the Course Names
        Map<String, List<String>> courseNamesByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::category,
                        Collectors.mapping(Course::name, Collectors.toList())
                ));
        System.out.println(courseNamesByCategory);

//Mapping Highest Rated Course Name by Category
        Map<String, String> highestRatedCourseNameByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::category,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Course::reviewScore)),
                                course -> course.map(Course::name).orElse(""))
                ));
        System.out.println(highestRatedCourseNameByCategory);
    }

}
