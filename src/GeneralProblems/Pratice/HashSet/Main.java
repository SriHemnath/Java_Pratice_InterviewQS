package GeneralProblems.Pratice.HashSet;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

//        hashMap();
        hashSet();
    }

    private static void hashMap(){
        HashMap<String, Person> hp = new HashMap<>();
        hp.put("Hemnath",new Person(new Address("India",1,2,"TN","street"),
                30, 12345, "Hemnath","uuid"));

        hp.put("Samantha",new Person(new Address("India",1,2,"TN","street"),
                30, 12345, "Hemnath","uuid"));
        hp.put("Samantha",new Person(new Address("India",1,2,"Delhi","street"),
                30, 12345, "Hemnath","uuid"));


        System.out.println(hp);
    }

    private static void hashSet(){
//        must override equals and hashcode.  if not, every class implements Object and hashcode,equals of that
//        will be taken which will result in duplicates.  HashSet will always add new values.

        HashSet<Person> hs = new HashSet<>();
        hs.add(new Person(new Address("India",1,2,"TN","street"),
                30, 12345, "Hemnath","uuid"));
        hs.add(
                new Person(new Address("India",1,2,"TN","street"),
                        30, 12345, "Samantha","uuid")
        );

        hs.add(
                new Person(new Address("US",1,2,"TN","street"),
                        30, 12345, "Samantha","uuid")
        );
        hs.add(
                new Person(new Address("US",1,2,"TN","street"),
                        30, 12345, "Samantha","uuid")
        );

        System.out.println(hs);
    }
}
