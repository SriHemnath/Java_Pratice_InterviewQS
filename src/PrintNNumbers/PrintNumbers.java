package PrintNNumbers;

import java.util.Scanner;

public class PrintNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int limit = in.nextInt();
        printNumners(limit,1);
    }

    static void printNumners(int limit, int start){
        if (start <= limit){
            System.out.println(start);
            printNumners(limit,++start);
        }
    }
}
