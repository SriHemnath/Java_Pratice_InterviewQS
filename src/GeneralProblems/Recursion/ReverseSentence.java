package GeneralProblems.Recursion;

public class ReverseSentence {
    public static void main(String[] args) {
        String str = "Learn Go";
        System.out.println(reverseSentence(str));
    }

    public static String reverseSentence(String str) {
        if (str.isEmpty())
            return str;
        return reverseSentence(str.substring(1)) + str.charAt(0);
    }
}
