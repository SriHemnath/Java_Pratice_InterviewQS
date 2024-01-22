package ExploreJava8;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>();
        for (int i= 1; i <=10 ; i++) ar.add(i);

        //method 1
        MyConsumer consumer = new MyConsumer();
        ar.forEach(consumer);

        //method 2 - manually call accept method to execute it
        Consumer<List<Integer>> displayList = list -> list.forEach(System.out::println);
        displayList.accept(ar);
    }
}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer i) {
        System.out.println(i);
    }
}

