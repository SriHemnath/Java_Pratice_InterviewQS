package GeneralProblems.Pratice.WordCount;

import java.util.HashMap;

/*Print the number of occurrence of words in sentence*/
public class CountWordsInSentence {
    public static void main(String[] args) {
        String str = "Hemnath start learning go language Hemnath";
        occurance(str);
    }

    static void occurance(String str) {
        String[] words = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                int count = map.get(words[i]);
                map.put(words[i], count + 1);
                continue;
            }
            map.put(words[i], 1);
        }
        System.out.println(map);
    }
}
