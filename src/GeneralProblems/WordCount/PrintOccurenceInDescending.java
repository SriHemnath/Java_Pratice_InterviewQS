package GeneralProblems.WordCount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintOccurenceInDescending {
    public static void main(String[] args) {
        printOccurrenceDescending("123231234");
    }

    static void printOccurrenceDescending(String str) {
        HashMap<Integer,Integer> ar = new HashMap<>();

        for(char c:str.toCharArray()){
            if (ar.containsKey(Integer.parseInt(String.valueOf(c)))){
                int value = ar.get(Integer.parseInt(String.valueOf(c)));
                ar.put(Integer.parseInt(String.valueOf(c)),value+1);
                continue;

            }
            ar.put(Integer.parseInt(String.valueOf(c)),1);
        }
        System.out.println(sortByValue(ar));
    }

    // function to sort hashmap by values
    public static HashMap<Integer, Integer>
    sortByValue(HashMap<Integer, Integer> hm)
    {
        HashMap<Integer, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return temp;
    }
}
