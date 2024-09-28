package Java8.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Example2 {
    public static void main(String[] args) {
        List<String> names =Arrays.asList("Hemnath","Jaishankar","Duraikannu");
        System.out.println("Printing List using forEach:");
        names.forEach(System.out::println);

        System.out.println("Printing using lambda and consumer:");
        printList(names, (String v) -> System.out.println(v));
        
        System.out.println("Using Functional Interface Consumer:");
        printList(names, System.out::println);

    }

    static <T> void printList(List<T> list, Consumer<T> consumer){
        for(T t:list){
            consumer.accept(t);
        }
    }
}
