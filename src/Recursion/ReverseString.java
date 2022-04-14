package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Joker&namtaB";
        System.out.println(reverse(s));
    }

    public static String reverse(String str) {

        if (str.isEmpty())
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

}
