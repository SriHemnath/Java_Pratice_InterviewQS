package GeneralProblems.Pratice.Java8.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>();
        for (int i= 1; i <=10 ; i++) ar.add(i);

        //method 1 - implement consumer interface and pass it to foreach method
        MyConsumer consumer = new MyConsumer();
        ar.forEach(consumer);

        //method 2 - use lambda expression to implement consumer and call it directly
        Consumer<List<Integer>> displayList = list -> list.forEach(System.out::println);
        displayList.accept(ar);
    }
}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer i) {
        System.out.println("Called from MyConsumer: "+i);
    }
}

