package GeneralProblems.CountOfNumsDivisibleBy3;

import java.util.stream.IntStream;

public class Java8 {
    public static void main(String[] args) {
        long result = DivideByCount(1, 500, 3);
        System.out.println(result);
    }

    public static long DivideByCount(int start, int end, int divisor) {
        return IntStream.rangeClosed(start, end).filter(n -> n % 3 == 0).count();
    }
}
