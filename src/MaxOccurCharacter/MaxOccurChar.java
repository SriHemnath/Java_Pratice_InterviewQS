package MaxOccurCharacter;

import java.util.HashMap;

public class MaxOccurChar {
    static final int ASCII_SIZE = 256;

    /*space complexity is constant & time complexity is O(n)*/
    static char solution(String str) {
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }

    /*time complexit O(n2)*/
    public static void printMaxAndMin(String str){
        int[] freq = new int[str.length()];
        char minChar = str.charAt(0), maxChar = str.charAt(0);
        int i, j, min, max;
        char string[] = str.toCharArray();
        for(i = 0; i < string.length; i++)
        {
            freq[i] = 1;
            for(j = i+1; j < string.length; j++)
            {
                if(string[i] == string[j] && string[i] != ' ' && string[i] != '0')
                {
                    freq[i]++;

                    string[j] = '0';
                }
            }
        }
        min = max = freq[0];
        for(i = 0; i <freq.length; i++)
        {
            if(min > freq[i] && freq[i] != '0')
            {
                min = freq[i];
                minChar = string[i];
            }
            if(max < freq[i])
            {
                max = freq[i];
                maxChar = string[i];
            }
        }
        System.out.println("Minimum occurring character: " + minChar);
        System.out.println("Maximum occurring character: " + maxChar);
    }

    public static void main(String[] args) {
        String str="Findtheminimumandmaximumoccurringcharacter";
        System.out.println("Maximum Occurring character "+solution(str));
        printMaxAndMin("Find the minimum and maximum occurring character");
        System.out.println("Maximum Occurring character "+solution("Apple"));
    }
}
