package GeneralProblems.Pratice.Turing_Pratice_Test.BaseBallGame;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static int calPoints(String[] ops){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        for(int score : stack) result += score;
        return result;
    }
}


class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ops = sc.nextLine().split(" ");
        System.out.println(Solution.calPoints(ops));

    }
}