package GeneralProblems.Pratice.NonOverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;

public class NonOverlappingIntervals {
    // Interval with start time & end time
    static class Interval
    {
        int start, end;

        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    // Function that find the free interval
    static void findFreeinterval(int[][] arr, int N)
    {
        // If there are no set of interval
        if (N <= 0)
        {
            return;
        }

        // To store the set of free interval
        ArrayList<Interval> p = new ArrayList<>();

        // Sort the given interval according
        // starting time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Iterate over all the interval
        for (int i = 1; i < N; i++)
        {

            // Previous interval end
            int prevEnd = arr[i - 1][1];

            // Current interval start
            int currStart = arr[i][0];

            // If ending index of previous
            // is less than starting index
            // of current, then it is free
            // interval
            if (prevEnd < currStart)
            {
                Interval interval = new Interval(prevEnd,
                        currStart);
                p.add(interval);
            }
        }

        if(p.isEmpty()){
            System.out.println("all are overlapping");
            return;
        }
        // Print the free interval
        for (int i = 0; i < p.size(); i++)
        {
            System.out.println("[" + p.get(i).start +
                    ", " + p.get(i).end + "]");
        }

    }

    // Driver code
    public static void main(String[] args)
    {

        // Given set of interval
        int[][] arr = { { 1, 3 },
                { 2, 4 },
                { 3, 5 },
                { 7, 9 } };

        int N = arr.length;

        // Function Call
        findFreeinterval(arr, N);

        int[][] arr1 = { {1, 3}, {9, 12}, {2, 4}, {6, 8} };
        findFreeinterval(arr1, arr1.length);
        int[][] arr2 = { {1, 2}, {2, 3} };
        findFreeinterval(arr2, arr2.length);

    }
}
