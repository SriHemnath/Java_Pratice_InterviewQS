package GeneralProblems.Pratice.SwapValuesWithoutTempVar;

import java.util.Scanner;

public class SwapTwoNumWithoutTempVar {
    public static void main(String[] args) {
        int x, y;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(x + " " + y);
    }
}
